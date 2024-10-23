package com.sin.sb1010_2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect {

//    @Pointcut("execution(public * *..chap07..*(..))")
    private void publicTarget(){

    }
    @Around("execution(public * *..chap07..*(..))")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();// 변경
        try{
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();//변경
            Signature sig = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) execute time : %d ns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish - start));//변경
        }
    }
}
