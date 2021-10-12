package com.briliantidea.restservices.controller;


import com.briliantidea.restservices.RestservicesApplication;
import com.briliantidea.restservices.model.apiResponse;
import com.briliantidea.restservices.model.user;
import com.briliantidea.restservices.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired(required = false)
    private TestService testService;

    private static final Logger logger = LogManager.getLogger(TestController.class);

    @RequestMapping(value = "/hellouser", method = RequestMethod.POST)
    public apiResponse helloUser(HttpServletRequest request, @RequestBody user inpUres, @RequestHeader("username") String Username, @RequestHeader("password") String Password) {

        logger.info("Start the proccess");

        return testService.getUserWelcomeSentense(inpUres, Username, Password);

    }

}
