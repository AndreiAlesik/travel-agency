package com.example.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ResponseObject<T> {
    private HttpStatus status;
    private String message;
    private T result;
}
