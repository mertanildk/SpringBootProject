package com.deke.testredisdbjpa.exceptions;


import com.deke.testredisdbjpa.dto.view.RuntimeErrorDto;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestRuntimeExp extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestRuntimeException.class)
    @ResponseBody
    public ResponseEntity<RuntimeErrorDto> handleRestRuntimeException(RestRuntimeException restRuntimeException) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RuntimeErrorDto runtimeErrorDto = new RuntimeErrorDto(restRuntimeException.getCode(), restRuntimeException.getMessage());
        return new ResponseEntity<>(runtimeErrorDto, httpHeaders, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullInputException.class)
    @ResponseBody
    public ResponseEntity<RuntimeErrorDto> handlNullInputException(NullInputException nullInputException) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RuntimeErrorDto runtimeErrorDto = new RuntimeErrorDto(nullInputException.getCode(), nullInputException.getMessage());
        return new ResponseEntity<>(runtimeErrorDto, httpHeaders, HttpStatus.BAD_REQUEST);
    }

    @Override
    @ResponseBody
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RuntimeErrorDto runtimeErrorDto = new RuntimeErrorDto("0001", "You are using a wrong http method");
        return new ResponseEntity<>(runtimeErrorDto, httpHeaders, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
//RestResponseEntity.response(hotelService.findOne(id)
