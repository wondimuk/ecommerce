package com.personal.productservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogAdvice {

    private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);

    @Pointcut("execution(* com.personal.productservice.service.ProductServiceImpl.addProduct(..))")
    private void productPointCut() {
    }

    @After("productPointCut()&&args(..)")
    private void productLogBefore(JoinPoint joinpoint) {
        Object[] obj = joinpoint.getArgs();
        log.info("Transaction name {}, transaction Date time {}, before change data", joinpoint.getSignature().getName(), LocalDateTime.now());
        System.out.println("logger done");
    }

    @AfterThrowing(value = "productPointCut()&&args(..)", throwing = "e")
    private void productLogError(JoinPoint joinPoint, Exception e) {
        log.error("Transaction name {} has error ", joinPoint.getSignature().getName(), e.getMessage());
    }
}
