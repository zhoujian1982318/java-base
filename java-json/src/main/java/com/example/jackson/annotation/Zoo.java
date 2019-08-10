package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName(value = "zoo")
public class Zoo {

    private String name;
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY , property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    private Animal animal;

    @JsonTypeName(value = "myAnimal")
    public static class Animal {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Zoo zoo = new Zoo();
        zoo.name = "test";

        Zoo.Animal animal = new Zoo.Animal();
        zoo.setAnimal(animal);
        animal.setName("my pet");
        String result  = new ObjectMapper().writeValueAsString(zoo);

        System.out.println("the result is ["+ result+"]");


        Zoo zoo1 = new Zoo();
        zoo1.name = "test";


        Zoo.Dog dog = new Zoo.Dog();
        dog.setName("My dog");

        zoo1.setAnimal(dog);
        String rs1 = new ObjectMapper().writeValueAsString(zoo1);

        System.out.println("the result is ["+ rs1+"]");


    }
}
