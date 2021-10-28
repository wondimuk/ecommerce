package com.personal.productservice.utils.DTO.exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String errorMessage){
        super(errorMessage);
    }
}
