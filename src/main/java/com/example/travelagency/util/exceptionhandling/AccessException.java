package com.example.travelagency.util.exceptionhandling;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AccessException extends RuntimeException{
    public AccessException() {
    }
}
