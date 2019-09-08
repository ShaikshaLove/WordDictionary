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
    public Word getWord(String name) {
        Word word=wordRepository.findWordByName(name);
        if(word==null)
            throw new WordNotFoundException(" The Word, "+name+ " is not available");
        return word ;
    }

    @Override
    public boolean isWordAvailble(String wordName) {
        try{
            getWord(wordName);
            return true;
        }catch(WordNotFoundException e){
            return false;
        }
    }

    @Override
    public void saveAllWords(MultipartFile multipartFile) throws IOException {

            InputStream is = multipartFile.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for(String word:words){
                    String lowerCase=word.toLowerCase().trim();
                    // Checking the word is existed in the db or not
                    if(!isWordAvailble(lowerCase))
                        //saving the word in db only if the word is not available in the DB
                     wordRepository.save(new Word(lowerCase));
                }
            }
    }
}
