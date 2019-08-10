package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum TypeEnumWithValue {
    TYPE1(1, "Type A"), TYPE2(2, "Type 2");

    private Integer id;
    private String name;

    TypeEnumWithValue(Integer theId,  String theName){
        this.id =  theId;
        this.name =  theName;
    }
    // jsonValue annotation "Type A"
    // no json Value annotation is "TYPE1"
    @JsonValue
    public String getName() {
        return name;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String enumAsString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);

        System.out.println("the emum stirng is ["+enumAsString+"]");
    }
}
