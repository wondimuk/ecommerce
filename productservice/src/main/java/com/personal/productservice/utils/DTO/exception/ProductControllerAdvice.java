package com.personal.productservice.utils.DTO.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleDataNotFound(NoDataFoundException noDataFoundException, WebRequest request){
        Map<String,Object> response = new HashMap();
        response.put("Date time", LocalDate.now());
        response.put("Status code", HttpStatus.NOT_FOUND);
        response.put("message","Data not found");
        return new ResponseEntity(response,HttpStatus.NOT_FOUND);

    }
}
