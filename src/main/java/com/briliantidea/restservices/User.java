package com.briliantidea.restservices;

public class User {
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  User(String name, String pass){
        username = name;
        password = pass;

    }
}
