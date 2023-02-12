package com.deke.testredisdbjpa.Aop;


import lombok.Getter;

@Getter
public enum LogType {
    READ("1","READ"), WRITE("2","WRITE");
    private final String type;
    private final String description;


    LogType(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
