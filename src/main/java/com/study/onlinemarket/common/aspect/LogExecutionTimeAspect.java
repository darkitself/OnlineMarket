package com.study.onlinemarket.common.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class LogExecutionTimeAspect {

    @Around("@annotation(com.study.onlinemarket.common.annotation.LogExecutionTime)")
    public Object timer(ProceedingJoinPoint point) throws Throwable {
        String methodName = String.format("%s.%s",
                point.getStaticPart().getSignature().getDeclaringType().getName(),
                point.getSignature().getName()
        );

        log.info("Before {} execution", methodName);

        long startAt = System.currentTimeMillis();

        try {
            return point.proceed(point.getArgs());
        } finally {
            long executionTime = System.currentTimeMillis() - startAt;
            log.warn("{} execution took {}ms", methodName, executionTime);
        }
    }
}
