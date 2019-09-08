package io.happiestminds.dictionaryapp.exeption;

public class WordNotFoundException extends RuntimeException{
    private String message;
    public WordNotFoundException(String message){
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
