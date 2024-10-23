package com.sin.sb1010_2.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Aspect
@Component
public class SampleAspect {
    @Around("execution(* *..aop2.*Greet.*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("======around Advice======");
        System.out.println("처리전");

        Object result = joinPoint.proceed();

        System.out.println("처리후");
    }
    @Before("execution(* *..aop2.*Greet.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("======Before Advice======");

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));

        System.out.println(String.format("메서드:%s", joinPoint.getSignature().getName()));
    }
    @After("execution(* *..aop2.*Greet.*(..))")
    public void AfterAdvice(JoinPoint joinPoint) {
        System.out.println("======After Advice======");

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));

        System.out.println(String.format("메서드:%s", joinPoint.getSignature().getName()));
    }
}
