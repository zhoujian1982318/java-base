package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UnwrappedUser{
    public int id;
    @JsonUnwrapped
    public Name name;

    public static class Name {
        public String firstName;
        public String lastName;
    }

    public static void main(String[] args) throws JsonProcessingException {
        UnwrappedUser.Name name = new UnwrappedUser.Name();
        name.firstName = "first";
        name.lastName = "last";
        UnwrappedUser user = new UnwrappedUser();
        user.id = 1;
        user.name = name;

        String result = new ObjectMapper().writeValueAsString(user);

        System.out.println("the result is ["+ result+"]");
    }
}
