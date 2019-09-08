package io.happiestminds.dictionaryapp;

import io.happiestminds.dictionaryapp.exeption.WordNotFoundException;
import io.happiestminds.dictionaryapp.model.Word;
import io.happiestminds.dictionaryapp.service.IWordService;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DictionaryAppApplicationTests {


    @Autowired
    IWordService wordService;

    @Test
    public void contextLoads() {

    }


    @Test
    public void testReadWord(){

        Word word=wordService.getWord("good");
        assertNotNull(word);
    }

    @Test
    public void testIsWordAvailable(){
        boolean available= wordService.isWordAvailble("education");
        assertEquals(available,false);
    }
}
