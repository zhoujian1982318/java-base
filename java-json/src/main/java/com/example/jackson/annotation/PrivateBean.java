package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PrivateBean {
    private int id;
    private String name;

    public PrivateBean(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        PrivateBean bean = new PrivateBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);

        System.out.println("the result is ["+ result+"]");
    }
}
