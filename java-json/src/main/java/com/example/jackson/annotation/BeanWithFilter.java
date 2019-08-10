package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@JsonFilter("myFilter")
public class BeanWithFilter {
    public int id;
    public String name;
    public int age;

    public static void main(String[] args) throws JsonProcessingException {
        BeanWithFilter bean = new BeanWithFilter();
        bean.id = 1;
        bean.name = "test";
        bean.age = 4;

        FilterProvider filters
                = new SimpleFilterProvider().addFilter(
                "myFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("name"));

        String result = new ObjectMapper()
                .writer(filters)
                .writeValueAsString(bean);

        System.out.println("the result is ["+ result+"]");

    }
}
