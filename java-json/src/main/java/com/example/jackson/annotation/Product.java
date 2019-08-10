package com.example.jackson.annotation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Product {
    private String name;
    private String category;

    private JsonNode details;

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

    public JsonNode getDetails() {
        return details;
    }

    public void setDetails(JsonNode details) {
        this.details = details;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url  = Product.class.getResource("/dynamic-object/embedded.json");
        URI uri = url.toURI();
        System.out.println("the url is:["+url.getFile()+"]");
        System.out.println("the uri is:["+uri+"]");
        byte []  bts = Files.readAllBytes(Paths.get(url.toURI()));

        String json = new String(bts);
        ObjectMapper obj = new ObjectMapper();

        Product product = obj.readValue(json, Product.class);
        JsonNode jsonNode  = product.getDetails();
        System.out.println("the detail is :" + jsonNode.get("displayAspectRatio").textValue());

    }
}
