package com.deke.testredisdbjpa.entity.dto;

import com.deke.testredisdbjpa.Aop.LogType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class LogAddDto {
    @NotEmpty
    @NotBlank
    private String userName;

    @NotEmpty
    @NotBlank
    private String operation;

    @NotEmpty
    private LocalDateTime time;

    @NotEmpty
    @NotBlank
    private String className;
    @NotEmpty
    private String method;

    @NotEmpty
    private String params;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private LogType logType;

    @NotEmpty
    private String ip;

    @PastOrPresent
    private Date createdAt;
}
