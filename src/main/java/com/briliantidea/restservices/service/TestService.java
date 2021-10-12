package com.briliantidea.restservices.service;

import com.briliantidea.restservices.model.user;
import com.briliantidea.restservices.model.apiResponse;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public apiResponse getUserWelcomeSentense(user inpUser, String Username, String Password) {

        apiResponse response = new apiResponse();
        response.setResponseCode(0);
        response.setResponseMessage("Successful Execution");

        return response;
    }

}
