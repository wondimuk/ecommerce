package com.personal.productservice.utils.DTO.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String errorMessage){
        super(errorMessage);
    }
}
