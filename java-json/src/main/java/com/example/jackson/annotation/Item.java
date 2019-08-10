package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Item {
    @JsonView(Views.Public.class)
    public int id;

    @JsonView(Views.Internal.class)
    public String itemName;

    @JsonView(Views.Internal.class)
    public String ownerName;

    public static void main(String[] args) throws JsonProcessingException {
        Item item = new Item();
        item.id = 2;
        item.itemName = "test";
        item.ownerName = "owner name";

        String result = new ObjectMapper()
                .writerWithView(Views.Internal.class)
                .writeValueAsString(item);
        System.out.println("the result is ["+ result+"]");
    }
}
