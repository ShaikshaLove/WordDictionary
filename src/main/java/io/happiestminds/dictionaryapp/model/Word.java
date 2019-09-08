package io.happiestminds.dictionaryapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Word {
    @Id
    @GeneratedValue(generator = "sequence")
    private long wordId;
    private String name;
    private String meaning;

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public String getMeaning() {
        return meaning;
    }

    public long getWordId() {
        return wordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name,String meaning) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Word(String name) {
        this.name = name;
        this.meaning="NA";
    }

    public Word() {
    }

    @Override
    public String toString() {
        return "Word [" +
                "  wordId= " + wordId +
                ", name= " + name +
                ", meaning= " + meaning +"]";
    }
}
