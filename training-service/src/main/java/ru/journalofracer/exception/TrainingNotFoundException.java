package ru.journalofracer.exception;

public class TrainingNotFoundException extends RuntimeException{
    public TrainingNotFoundException(String message){
        super(message);
    }
}
