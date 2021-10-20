package com.briliantidea.restservices.dao;
import com.briliantidea.restservices.User;

public interface UserRepository {

    void addUser(User user);

    boolean authenticateUser(User user);
}
