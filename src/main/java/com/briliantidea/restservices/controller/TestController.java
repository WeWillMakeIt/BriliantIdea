package com.briliantidea.restservices.controller;


import com.briliantidea.restservices.AddUserResponse;
import com.briliantidea.restservices.User;
import com.briliantidea.restservices.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired(required = false)
    private TestService testService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LogManager.getLogger(TestController.class);

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public AddUserResponse addUser(HttpServletRequest request, @RequestBody User user) {

        return testService.addNewUser(user);

    }

    @RequestMapping(value = "/checkPass", method = RequestMethod.POST)
    public String checkUserPass(HttpServletRequest request, @RequestBody User user) {

       return testService.authenticateUser(user);

    }


}
