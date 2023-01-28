package com.deke.testredisdbjpa.exceptions;


import com.deke.testredisdbjpa.exceptions.base.BaseException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;


@Getter
@Setter
@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class RestRuntimeException extends BaseException {

    public RestRuntimeException(String message, String code) {super(message, code);}

    public RestRuntimeException() {super();}

    @Serial
    private static final long serialVersionUID = 1111112L;
}
