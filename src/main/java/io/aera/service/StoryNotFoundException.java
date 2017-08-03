package io.aera.service;

public class StoryNotFoundException extends RuntimeException {
    public StoryNotFoundException(String message){
        super(message);
    }
}
