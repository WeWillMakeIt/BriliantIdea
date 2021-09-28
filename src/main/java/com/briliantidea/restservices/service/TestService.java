package com.briliantidea.restservices.service;

import com.briliantidea.restservices.model.user;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String getUserWelcomeSentense(user inpUser){

       return "Hello" + " " + inpUser.getName() + " " + inpUser.getFamily() + ". You are " + inpUser.getAge().toString();
    }
}
