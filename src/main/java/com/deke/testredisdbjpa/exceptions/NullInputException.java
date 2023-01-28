package com.deke.testredisdbjpa.exceptions;


import com.deke.testredisdbjpa.exceptions.base.BaseException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;


@Getter
@Setter
@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class NullInputException extends BaseException {


    public NullInputException(String code) {
        super("You Should Give Me At Least One Key", code);
    }

    public NullInputException() {
        super();
    }

    @Override
    public void setMessage(String message) {
        super.setMessage(message);
    }
}
