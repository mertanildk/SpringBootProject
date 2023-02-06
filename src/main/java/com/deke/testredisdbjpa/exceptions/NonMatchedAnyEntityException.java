package com.deke.testredisdbjpa.exceptions;

import com.deke.testredisdbjpa.constants.messageConstants.ExceptionMessages;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;


@Getter
@Setter
@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class NonMatchedAnyEntityException extends RuntimeException {


    private String code;
    private String message;
    private String className;

    public NonMatchedAnyEntityException(String code) {
        this.code = code;
    }


    @Override
    public String getMessage() {
        return message;
    }


    public NonMatchedAnyEntityException(String className, String code) {
        this.className = className;
        this.message = ExceptionMessages.NON_MATCHED_BY_ID + "class name:" + className;
        this.code = code;

    }

    public NonMatchedAnyEntityException() {

    }


}
