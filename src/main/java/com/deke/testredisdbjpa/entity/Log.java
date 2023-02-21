package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.Aop.LogType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
@Data
public class Log {
    @Id
    private String oid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Date deleted;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdated = new Date();
    private String userName;
    private String operation;
    private String time;
    private String method;
    private String params;
    @Enumerated(EnumType.STRING)
    private LogType logType;
    private String ip;
}
