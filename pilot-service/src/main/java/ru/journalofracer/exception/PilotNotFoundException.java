package ru.journalofracer.exception;

public class PilotNotFoundException extends RuntimeException{
    public PilotNotFoundException(String message){
        super(message);
    }
}
