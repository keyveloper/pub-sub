package org.example;

public class DataRequestException extends RuntimeException{
    public DataRequestException(){
        super("no data exists");
    }
}
