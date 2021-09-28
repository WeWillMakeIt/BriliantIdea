package com.briliantidea.restservices.model;

public class user {
    private String name;
    private String family;
    private Integer age;

    public void setName(String name){ this.name = name;}
    public void setFamily(String family){ this.family = family;}
    public void setAge(Integer age){ this.age = age;}
    public  String getName(){return this.name;}
    public  String getFamily(){return this.family;}
    public  Integer getAge() {return  this.age;}
}
