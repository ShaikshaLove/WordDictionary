package io.happiestminds.dictionaryapp.service;

import io.happiestminds.dictionaryapp.model.Word;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IWordService {
    public boolean saveAllWords(MultipartFile multipartFile);
    public Word getWord(String wordName);
}