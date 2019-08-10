package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductJsonAnySetter {

    private String name;
    private String category;


    private Map<String, Object> details = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @JsonAnyGetter
    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetail(String key, Object value) {
        details.put(key, value);
    }


    public static void main(String[] args) throws JsonProcessingException {
        ProductJsonAnySetter obj = new ProductJsonAnySetter();

        obj.setName("test");
        obj.getDetails().put("attr", "attr");
        obj.getDetails().put("attr1","attr1");
        String result = new ObjectMapper().writeValueAsString(obj);
        System.out.println(result);

    }

}
