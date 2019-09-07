package io.happiestminds.dictionaryapp.controller;

import io.happiestminds.dictionaryapp.exeption.WordNotFoundException;
import io.happiestminds.dictionaryapp.model.Word;
import io.happiestminds.dictionaryapp.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.ArrayList;

@Controller
public class WordController {

    @Autowired
    private IWordService wordService;

    @RequestMapping(value="/uploadFile",method = RequestMethod.POST)
    public ModelAndView saveAllWords(@RequestParam("file") MultipartFile multipartFile) {

        if (!multipartFile.getContentType().equals("text/plain")) {
            return new ModelAndView("fileUpload", "message", "Please upload only text file");
        } else {
            if(wordService.saveAllWords(multipartFile)) {
                return new ModelAndView("fileUpload", "message", "All words in the file were Uploaded successfully");
            }else{
                return new ModelAndView("fileUpload", "message", "Some  words in the file are already available  in the database. Only the words,which are new, were stored in the data base");
            }
        }
    }


    @RequestMapping(value="/searchWord",method = RequestMethod.GET)
    public ModelAndView getWord(@RequestParam("word") String wordName){
        Word word=wordService.getWord(wordName);
        return new ModelAndView("fileUpload","msg",word+" is available in the database ");
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String fileUploadPage(){
       return "fileUpload";
    }


    // Handling code for  WordNotFoundException
    @ExceptionHandler(WordNotFoundException.class)
    public ModelAndView handle(WordNotFoundException exception){
        return new ModelAndView("fileUpload","errMsg",exception.getMessage());
    }

}
