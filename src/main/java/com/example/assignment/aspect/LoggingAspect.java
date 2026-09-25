package com.example.assignment.aspect;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect implements LogoutHandler {
    private static final Logger logger = Logger.getLogger("LoggingAspect");

    @PostConstruct
    public void logStartup() {
        logger.info("Application started successfully");
    }

    @Before("execution(* com.example.assignment.api.PersonApi..*(..))")
    public void log(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null){
            logger.warning("Failed authentication attempts");
        }
        else {
            logger.info("Successfully logged in: " + authentication.getName());
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, @Nullable Authentication authentication) {
        if (authentication != null){
            logger.info("User logged out: " + authentication.getName());
        }
    }
}


