package com.example.jackson.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;

//@JsonSerialize(using = CustomerItemSerializer.class)
// 或者 使用 ObjectMapper
// ObjSimpleModule module = new SimpleModule();
//        module.addSerializer(CustomerItem.class, new CustomerItemSerializer());
//        mapper.registerModule(module);
//@JsonDeserialize(using = CustomerItemDeserializer.class)
public class CustomerItem {

    private int id;
    private String itemName;
    private CustomerUser owner;

    public CustomerItem(int id, String itemName, CustomerUser theUser) {
        this.id = id;
        this.itemName = itemName;
        this.owner = theUser;
    }

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

    public CustomerUser getOwner() {
        return owner;
    }

    public void setOwner(CustomerUser owner) {
        this.owner = owner;
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(CustomerItem.class, new CustomerItemSerializer());
        mapper.registerModule(module);

        CustomerItem myItem = new CustomerItem(1, "theItem", new CustomerUser(2, "theUser"));
        String serialized = mapper.writeValueAsString(myItem);
        System.out.println("the serialized string is ["+serialized+"]");
    }
}
