package com.briliantidea.restservices.model;

public class user {
    private String name;
    private String family;
    private Integer age;
    private String username;
    private String password;

    public void setName(String name){ this.name = name;}
    public void setFamily(String family){ this.family = family;}
    public void setAge(Integer age){ this.age = age;}
    public void setUsername(String username){ this.username = username;}
    public void setPassword(String password){ this.password = password;}
    public  String getName(){return this.name;}
    public  String getFamily(){return this.family;}
    public  Integer getAge() {return  this.age;}
    public  String getUsername(){return this.username;}
    public  String getPassword() {return this.password;}
}
