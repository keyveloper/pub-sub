package org.example;

public class NotFoundKeyException extends RuntimeException{
    public NotFoundKeyException(){
        super("Key is not founded");
    }
}
