package com.rentaladda.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.rentaladda.controller.HomeController.*(..))")
    public void logWhenEncountered(JoinPoint joinPoint){
        System.out.println("in welc.ome Aspect controlled log");
        System.out.println(joinPoint.getSignature().getName());
    }

}
