package com.example.travelagency.util.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException() {
    }
    /*private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }*/
}