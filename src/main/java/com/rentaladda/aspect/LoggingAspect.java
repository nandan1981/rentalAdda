package com.rentaladda.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.rentaladda.*.*(..))")
    public void logWhenEncountered(JoinPoint joinPoint){
        System.out.println("in welcome Aspect controlled log");
        System.out.println(joinPoint.getSignature().getName());
    }

}
