package com.briliantidea.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sun.font.TrueTypeFont;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RestservicesApplication {

    private static final Logger logger = LogManager.getLogger(RestservicesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestservicesApplication.class, args);

       logger.info("Application has been started");


    }

}
