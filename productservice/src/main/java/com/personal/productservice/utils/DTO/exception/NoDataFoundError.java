package com.personal.productservice.utils.DTO.exception;


public class NoDataFoundError extends RuntimeException{
    public NoDataFoundError() {
    }

    public NoDataFoundError(String message) {
        super(message);
    }

    public NoDataFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDataFoundError(Throwable cause) {
        super(cause);
    }

    public NoDataFoundError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
