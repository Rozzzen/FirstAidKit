package com.zhuk.exception.handler;

import com.zhuk.domain.Order;
import com.zhuk.exception.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AidkitNotFoundException.class)
    public ResponseEntity<ExceptionResponse> aidkitNotFoundException(AidkitNotFoundException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(BandageNotFoundException.class)
    public ResponseEntity<ExceptionResponse> bandageNotFoundException(BandageNotFoundException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(GarrotNotFoundException.class)
    public ResponseEntity<ExceptionResponse> garrotNotFoundException(GarrotNotFoundException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(GlovesNotFoundException.class)
    public ResponseEntity<ExceptionResponse> glovesNotFoundException(GlovesNotFoundException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ExceptionResponse> orderNotFoundException(OrderNotFoundException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> bindException(MethodArgumentNotValidException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ExceptionResponse> roleNotFoundException(RoleNotFoundException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFoundException(UserNotFoundException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> sqlIntegrityViolationException(SQLIntegrityConstraintViolationException ex) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
        log.info(ex.getMessage());
        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}
