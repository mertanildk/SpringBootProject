package com.deke.testredisdbjpa.exceptions.base;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private String message;
    private String code;

    public BaseException(String code) {
        this.code = code;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
