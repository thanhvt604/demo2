package com.example.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LoggerComponent {

    @Before("execution(* com.example.controller.BookController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("before method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.controller.BookController.*(..)))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("before method: " + joinPoint.getSignature().getName());
    }

    // chỉ thực hiện log với method2 của Hello.java
    @AfterReturning(pointcut = "execution(* com.example.controller.BookController.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("after return method : " + joinPoint.getSignature().getName());
        log.info("Method returned value is : " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.controller.BookController.*(..))", throwing = "error")
    public void logThrow(JoinPoint joinPoint, Throwable error) {
        log.info("exception in method: " + joinPoint.getSignature().getName());
       log.error("Exception is: " + error);
    }

}
