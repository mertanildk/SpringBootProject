package com.deke.testredisdbjpa.Aop;

import com.deke.testredisdbjpa.entity.dto.LogAddDto;
import com.deke.testredisdbjpa.service.LogService;
import com.deke.testredisdbjpa.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class LogAspect {

    private final LogService logService;

    public LogAspect(LogService logService) {
        this.logService = logService;
    }

    @Pointcut("@annotation(com.deke.testredisdbjpa.Aop.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        saveLog(point);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        LogAddDto logAddDto = new LogAddDto();
        logAddDto.setIp(HttpUtil.getClientIpAddressIfServletRequestExist());
        logAddDto.setClassName(joinPoint.getTarget().getClass().getName());
        logAddDto.setUserName(joinPoint.getClass().getName());
        logAddDto.setLogType(log.value());
        logAddDto.setMethod(signature.getName());
        logAddDto.setOperation(joinPoint.getClass().getPackageName().repeat(2));
        logService.createLog(logAddDto);
    }
}
