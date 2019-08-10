package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//{"id":2,"itemName":"item1","owner":{"id":1,"name":"hello-user","userItems":[2]}}
public class UserWithRef {

    private int id;
    private String name;
//    @JsonBackReference
//    {"id":2,"itemName":"item1","owner":{"id":1,"name":"hello-user"}}
    private List<ItemWithRef> userItems;

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

    public List<ItemWithRef> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<ItemWithRef> userItems) {
        this.userItems = userItems;
    }

    public static void main(String[] args) throws JsonProcessingException {
        UserWithRef user = new UserWithRef();
        user.id = 1;
        user.setName("hello-user");


        ItemWithRef item = new ItemWithRef();
        item.setId(2);
        item.setItemName("item1");
        item.setOwner(user);

        List<ItemWithRef> itemList = new ArrayList<>();
        itemList.add(item);
        user.setUserItems(itemList);

        String result = new ObjectMapper().writeValueAsString(item);

        System.out.println("the result is ["+ result+"]");
    }
}
