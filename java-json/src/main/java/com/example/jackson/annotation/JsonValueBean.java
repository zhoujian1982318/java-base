package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValueBean {
    @JsonValue
    private String name;
    //only one json value annotation. otherwise throw exception
    //@JsonValue
    private String title;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws JsonProcessingException {
        JsonValueBean jsonValueBean = new JsonValueBean();
        jsonValueBean.setAge(8);
        jsonValueBean.setName("jason");
        jsonValueBean.setTitle("programmer");

        String beanAsString = new ObjectMapper().writeValueAsString(jsonValueBean);

        System.out.println("the json string is["+beanAsString+"]");
    }
}
