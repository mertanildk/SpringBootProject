package com.deke.testredisdbjpa.exceptions;


import com.deke.testredisdbjpa.cons.ExceptionMessages;
import com.deke.testredisdbjpa.dto.view.RuntimeErrorDto;
import org.springframework.http.*;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
    public ResponseEntity<RuntimeErrorDto> handleNonMatchedAnyEntityException(NonMatchedAnyEntityException nullInputException){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RuntimeErrorDto runtimeErrorDto =
                new RuntimeErrorDto(nullInputException.getCode(), nullInputException.getMessage(), nullInputException.getClassName());
        return new ResponseEntity<>(runtimeErrorDto,httpHeaders, HttpStatus.BAD_REQUEST);
    }

    @Override
    @ResponseBody

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RuntimeErrorDto runtimeErrorDto = new RuntimeErrorDto("0001", ExceptionMessages.HTTP_REQUEST_WRONG_METHOD);
        return new ResponseEntity<>(runtimeErrorDto, httpHeaders, HttpStatus.BAD_REQUEST);
    }


}
//RestResponseEntity.response(hotelService.findOne(id)
