package com.briliantidea.restservices.aspect;

import com.briliantidea.restservices.AddUserResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component

public class ServiceAspect {

    private static final Logger logger = LogManager.getLogger(ServiceAspect.class);

 //   @Around(value = "execution(* com.briliantidea.restservices.controller.TestController.*(..))")
    public Object checkSecurity(ProceedingJoinPoint j) throws Throwable {
        String username = ((HttpServletRequest) j.getArgs()[0]).getHeader("username");
        String password = ((HttpServletRequest) j.getArgs()[0]).getHeader("password");
        Object response;
        AddUserResponse errorMessage;

        if (!username.equals("bsh")) {
            logger.error("Invalid User for " + j.getSignature().toString());

            errorMessage = new AddUserResponse();
            errorMessage.setResponseCode(1);
            errorMessage.setResponseMessage("Invalid User");
            return errorMessage;
        } else
            logger.info("User Authenticated for " + j.getSignature().toString());
            return j.proceed();

    }
}