package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class BeanWithInject {
    @JacksonInject
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {

        String json = "{\"name\":\"My bean\"}";

        InjectableValues inject = new InjectableValues.Std()
                .addValue(int.class, 3);
        BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);
        System.out.println("the id of bean is ["+bean.getId()+"]");

    }
}
