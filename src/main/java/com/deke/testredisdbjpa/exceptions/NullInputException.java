package com.deke.testredisdbjpa.exceptions;


import com.deke.testredisdbjpa.constants.messageConstants.ExceptionMessages;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;


@Getter
@Setter
@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class NullInputException extends RuntimeException {

    private String code;
    private String message = ExceptionMessages.NULL_INPUT;
    private String className;

    public NullInputException(String code) {
        this.code = code;
    }

    public NullInputException() {
        super();
    }

    public NullInputException(String message, String code, String className) {
        this.code = code;
        this.message = message;
        this.className = className;
    }

    public NullInputException(String className, String code) {
        this.code = code;
        this.className = className;
    }
}
