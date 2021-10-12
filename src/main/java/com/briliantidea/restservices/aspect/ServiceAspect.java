package com.briliantidea.restservices.aspect;

import org.apache.tomcat.jni.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.briliantidea.restservices.model.user;
import org.springframework.web.server.ResponseStatusException;
import com.briliantidea.restservices.model.apiResponse;


import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component

public class ServiceAspect {

    private static final Logger logger = LogManager.getLogger(ServiceAspect.class);

    @Around(value = "execution(* com.briliantidea.restservices.controller.TestController.*(..))")
    public Object checkSecurity(ProceedingJoinPoint j) throws Throwable {
        String username = ((HttpServletRequest) j.getArgs()[0]).getHeader("username");
        String password = ((HttpServletRequest) j.getArgs()[0]).getHeader("password");
        Object response;
        apiResponse errorMessage;

        if (!username.equals("bsh")) {
            logger.error("Invalid User for " + j.getSignature().toString());

            errorMessage = new apiResponse();
            errorMessage.setResponseCode(1);
            errorMessage.setResponseMessage("Invalid User");
            return errorMessage;
        } else
            logger.info("User Authenticated for " + j.getSignature().toString());
            return j.proceed();

    }
}