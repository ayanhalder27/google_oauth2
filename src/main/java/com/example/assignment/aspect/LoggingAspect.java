package com.example.assignment.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = Logger.getLogger("LoggingAspect");

    @Before("execution(* com.example.assignment.api.PersonApi..*(..))")
    public void log(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info(authentication.getName());
    }
}


