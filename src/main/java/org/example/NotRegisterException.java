package org.example;

public class NotRegisterException extends RuntimeException{
    public NotRegisterException(){
        super("not be registered id");
    }
}
