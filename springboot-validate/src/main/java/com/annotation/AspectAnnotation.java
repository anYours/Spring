package com.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAnnotation {

    @Pointcut("@annotation(MyAnnotation)")
    private void cut(){}

    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long beginTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long time = System.currentTimeMillis()-beginTime;
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        String className = joinPoint.getTarget().getClass().getName();
        System.out.println("class:"+className+"  method:"+name+"  耗时："+time);
        return result;
    }
}
