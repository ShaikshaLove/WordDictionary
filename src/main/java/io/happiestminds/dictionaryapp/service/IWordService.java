package io.happiestminds.dictionaryapp.service;

import io.happiestminds.dictionaryapp.model.Word;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IWordService {
    public void saveAllWords(MultipartFile multipartFile) throws IOException;
    public Word getWord(String wordName);
    public boolean isWordAvailble(String wordName);
}