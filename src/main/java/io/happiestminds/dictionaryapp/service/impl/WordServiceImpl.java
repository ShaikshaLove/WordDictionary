package io.happiestminds.dictionaryapp.service.impl;

import io.happiestminds.dictionaryapp.exeption.WordNotFoundException;
import io.happiestminds.dictionaryapp.model.Word;
import io.happiestminds.dictionaryapp.repsoitory.WordRepository;
import io.happiestminds.dictionaryapp.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements IWordService {

    @Autowired
    private WordRepository wordRepository;

    @Override
    public Word getWord(String wordName) {
        Word word=wordRepository.findWordByWord(wordName);
        if(word==null)
            throw new WordNotFoundException(" The Word, "+wordName+ " is not available");
        return word ;
    }

    @Override
    public boolean saveAllWords(MultipartFile multipartFile) {
        boolean duplicatesFound=false;
        try {
            ArrayList<Word> wordList=new ArrayList<>();
            InputStream is = multipartFile.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for(String word:words){
                    // checking the word is available or not in the database
                    if(!(wordRepository.findWordCountByWord(word)>0))
                    wordList.add(new Word(word));
                }
            }
            wordRepository.saveAll(wordList);
          } catch (IOException e) {
            e.printStackTrace();
         }
        return duplicatesFound;
    }
}
