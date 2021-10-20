package com.briliantidea.restservices.service;

import com.briliantidea.restservices.AddUserResponse;
import com.briliantidea.restservices.RestservicesApplication;
import com.briliantidea.restservices.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briliantidea.restservices.dao.UserRepository;

@Service
public class TestService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LogManager.getLogger(TestService.class);


    public AddUserResponse addNewUser(User user) {
        AddUserResponse response = new AddUserResponse();

        try {
            userRepository.addUser(user);

            logger.info("User " + user.getUsername() + " has been inserted successfully");

            response.setResponseCode(0);
            response.setResponseMessage("User Added Successfully");

            return response;
        } catch (Exception e) {
            logger.error(e.getMessage().toString());

            response.setResponseCode(1);
            response.setResponseMessage("Error in saving User");
            return response;
        }
    }


    public String authenticateUser(User user) {
        try {

            if (userRepository.authenticateUser(user)){
                logger.info("User:" + user.getUsername() + " has been authenticated");
                return "User is authenticated";}
            else
                logger.info("User:" + user.getUsername() + " is not authenticated");
                return "Authentication failed";

        }
        catch (Exception e) {
            logger.error(e.getMessage().toString());
            return "Internal Error";
        }
    }
}
