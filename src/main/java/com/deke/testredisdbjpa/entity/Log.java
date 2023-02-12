package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.Aop.LogType;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "log")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log extends BaseEntity {
    @Column(name = "user_name")
    private String userName;

    @Column(name = "operation")
    private String operation;

    @Column(name = "time")
    private String time;

    @Column(name = "method")
    private String method;

    @Column(name = "params")
    private String params;

    @Column(name = "logType")
    @Enumerated(EnumType.STRING)
    private LogType logType;

    @Column(name = "ip")
    private String ip;
}
