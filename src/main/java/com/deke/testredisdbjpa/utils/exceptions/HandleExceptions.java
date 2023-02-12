package com.deke.testredisdbjpa.utils.exceptions;


import com.deke.testredisdbjpa.utils.messages.ExceptionMessages;
import com.deke.testredisdbjpa.entity.dto.view.RuntimeErrorDto;
import lombok.NonNull;
import org.springframework.http.*;
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
public class HandleExceptions extends ResponseEntityExceptionHandler {

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
    public ResponseEntity<RuntimeErrorDto> handleNullInputException(NullInputException nullInputException) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RuntimeErrorDto runtimeErrorDto = new RuntimeErrorDto(nullInputException.getCode(), nullInputException.getMessage());
        return new ResponseEntity<>(runtimeErrorDto, httpHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NonMatchedAnyEntityException.class)
    @ResponseBody
    public ResponseEntity<RuntimeErrorDto> handleNonMatchedAnyEntityException(NonMatchedAnyEntityException nullInputException) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RuntimeErrorDto runtimeErrorDto =
                new RuntimeErrorDto(nullInputException.getCode(), nullInputException.getMessage(), nullInputException.getClassName());
        return new ResponseEntity<>(runtimeErrorDto, httpHeaders, HttpStatus.BAD_REQUEST);
    }

    @Override
    @ResponseBody
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported
            (@NonNull HttpRequestMethodNotSupportedException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RuntimeErrorDto runtimeErrorDto = new RuntimeErrorDto("0001", ExceptionMessages.HTTP_REQUEST_WRONG_METHOD);
        return new ResponseEntity<>(runtimeErrorDto, httpHeaders, HttpStatus.BAD_REQUEST);
    }

    @Override//validation
    protected ResponseEntity<Object> handleMethodArgumentNotValid
            (MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {

        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));
        ex.getBindingResult().getGlobalErrors().forEach(error -> errors.add(error.getObjectName() + ": " + error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
