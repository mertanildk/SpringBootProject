package com.deke.testredisdbjpa.exceptions;


import com.deke.testredisdbjpa.constants.messageConstants.ExceptionMessages;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;


@Getter
@Setter
@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class RestRuntimeException extends RuntimeException {

    private String code;
    private String message = ExceptionMessages.NULL_INPUT;
    private String className;

    public RestRuntimeException(String code) {
        this.code = code;
    }

    public RestRuntimeException(String className, String code) {
        this.code = code;
        this.className = className;
    }

    public RestRuntimeException() {

    }

    @Serial
    private static final long serialVersionUID = 1111112L;
}
