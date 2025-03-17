package com.api.exception;

import com.api.payload.ErrorDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice

public class GlobalExceptionHandler {

    //handle record not found exeption only i.e specific
//    @ExceptionHandler(ResourceNotFoundExeption.class)
//    public ResponseEntity<String> resourceNotFound(ResourceNotFoundExeption r){
//
//
//        return new ResponseEntity<>(r.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//
//
//    }

    //to handle global exception all type

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleGlobalException(Exception e){
//
//
//        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//
//
//    }

    //sending response to postman msg,date,uri

   @ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<ErrorDto> resourceNotFound(ResourceNotFoundExeption r,WebRequest request){
         ErrorDto error= new ErrorDto(r.getMessage(),new Date(),request.getDescription(true));

        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);


    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDto> handleDataIntegrityViolationException(DataIntegrityViolationException d,WebRequest request){
       ErrorDto error= new ErrorDto(d.getMessage(), new Date(),request.getDescription(true));
       return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }




}
