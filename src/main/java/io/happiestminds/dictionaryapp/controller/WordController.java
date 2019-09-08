package io.happiestminds.dictionaryapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import io.happiestminds.dictionaryapp.exeption.WordNotFoundException;
import io.happiestminds.dictionaryapp.model.Word;
import io.happiestminds.dictionaryapp.service.IWordService;
/*
* @author shaiksha
* */
@Controller
public class WordController {

    @Autowired
    private IWordService wordService;   
    
    /*
     *  It can process the file content and uploads all  words into data base
     */
    @RequestMapping(value="/uploadFile",method = RequestMethod.POST)
    public ModelAndView saveAllWords(@RequestPart("myFile") MultipartFile multipartFile) throws IOException {
    	 
    	   long  fileSize=(multipartFile.getSize());
           long limit=2*1024*1024;// 200MB
           if(!multipartFile.getContentType().equals("text/plain")) {
               return new ModelAndView("fileUpload", "message", "Please upload only text file (.txt) ");
           }
           else if(fileSize>limit){
                return new ModelAndView("fileUpload", "message", "The File size should be Less than 200 MB");
            }
           else {
               wordService.saveAllWords(multipartFile);
               return new ModelAndView("fileUpload", "message", "Only  the unique words of the file were Uploaded successfully");
           }
    }
    

    /*
     *  It can find a word is available or not in DB
     */
    @RequestMapping(value="/searchWord",method = RequestMethod.GET)
    public ModelAndView getWord(@RequestParam("word") String wordName){
        Word word=wordService.getWord(wordName);
        return new ModelAndView("fileUpload","msg",word+" is available in the database ");
    }


    /*
     *   Returning UI page
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String fileUploadPage(){
       return "fileUpload";
    }


    /*
     *    Handling code for  WordNotFoundException
     */
    @ExceptionHandler(WordNotFoundException.class)
    public ModelAndView handle(WordNotFoundException exception){
        return new ModelAndView("fileUpload","errMsg",exception.getMessage());
    }


    /*
    * Handling IOException
    * */

    @ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(IOException e){
        return new ModelAndView("fileUpload","errMsg","The Error has been Encountered during processing of the file. Try again ");
    }

}
