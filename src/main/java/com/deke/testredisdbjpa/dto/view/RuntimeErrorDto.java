package com.deke.testredisdbjpa.dto.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class RuntimeErrorDto implements Serializable {

    //private static final long serialVersionUID = -1387994548674507997L;

    public RuntimeErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RuntimeErrorDto(String code, String message,String className) {
        this.code = code;
        this.message = message;
        this.className = className;
    }

    private Boolean success = false;
    private String code;
    private String message;

    @JsonProperty("entityName")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String className;


}
