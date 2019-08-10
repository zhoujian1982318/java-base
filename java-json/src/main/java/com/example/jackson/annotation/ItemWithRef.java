package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ItemWithRef {

    private int id;
    private String itemName;

//    @JsonManagedReference
//    {"id":2,"itemName":"item1","owner":{"id":1,"name":"hello-user"}}

    private UserWithRef owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public UserWithRef getOwner() {
        return owner;
    }

    public void setOwner(UserWithRef owner) {
        this.owner = owner;
    }
}
