package com.example.billingbackend.exception;


import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class InvalidPriceException extends RuntimeException{

    public InvalidPriceException(String message) {
        super(message);
    }
}
