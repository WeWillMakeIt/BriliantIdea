package com.briliantidea.restservices.controller;


import com.briliantidea.restservices.model.user;
import com.briliantidea.restservices.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired(required = false)
    private TestService testService;

    @RequestMapping(value = "/hellouser", method = RequestMethod.POST)
    public String helloUser(@RequestBody user inpUres) {

        return testService.getUserWelcomeSentense(inpUres);
    }
}
