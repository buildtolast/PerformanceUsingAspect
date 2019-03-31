package com.codrite.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static java.lang.System.nanoTime;
@Component
@Slf4j
@Aspect
public class PerformanceMetricsUsingAspect {

    @Around("execution (* com.codrite.aop.*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        long time = nanoTime();
        Object object = pjp.proceed();
        log.info("[Performance] {}.{} executed in : {} millis", pjp.getSignature().getDeclaringType().getName(), pjp.getSignature().getName(), (nanoTime() - time)/1000000);
        return object;
    }

}
