package com.vrtouristservice.Controller;

import com.vrtouristservice.Exception.TouristAlreadyExistsException;
import com.vrtouristservice.Exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<String> handleTouristNotFoundException(TouristNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(TouristAlreadyExistsException.class)
    public ResponseEntity<String> handleTouristAlreadyExistsException(TouristAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> UnknownException(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
