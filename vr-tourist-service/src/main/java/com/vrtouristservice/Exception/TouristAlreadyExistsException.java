package com.vrtouristservice.Exception;

public class TouristAlreadyExistsException extends RuntimeException{
    public TouristAlreadyExistsException(String message){
        super(message);
    }
}
