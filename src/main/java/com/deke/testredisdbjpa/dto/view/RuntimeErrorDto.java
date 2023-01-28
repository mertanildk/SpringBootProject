package com.deke.testredisdbjpa.dto.view;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter @Setter
public class RuntimeErrorDto implements Serializable {

        //private static final long serialVersionUID = -1387994548674507997L;

        public RuntimeErrorDto(String code, String message) {
            this.code = code;
            this.message = message;
        }
        private Boolean success = false;
        private String code;
        private String message;


}
