package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RawBean {
    private String name;

    //{"name":"My bean","json":"{\"attr\":false}"}  no  JsonRawValue annotation
    //{"name":"My bean","json":{"attr":false}}  has JsonRawValue annotation
    @JsonRawValue
    private String json;

    public RawBean(String theName, String theJson){
        this.name = theName;
        this.json = theJson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public static void main(String[] args) throws JsonProcessingException {
        RawBean bean = new RawBean("My bean", "{\"attr\":false}");

        String result = new ObjectMapper().writeValueAsString(bean);

        System.out.println("the result is : [" + result+"]");
    }
}
