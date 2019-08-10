package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserIgnoreType {
    private int id;
    private Name name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @JsonIgnoreType
    public static class Name {
        public String firstName;
        public String lastName;

        public Name(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        UserIgnoreType.Name name = new UserIgnoreType.Name("John", "Doe");

        UserIgnoreType user = new UserIgnoreType();
        user.setId(1);
        user.setName(name);
        String result = new ObjectMapper().writeValueAsString(user);

        System.out.println("the result is ["+result+"]");

    }
}
