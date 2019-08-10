package com.example.jackson.annotation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ArrayListSample {

    public static class  MyDto {
        private String stringVal;
        private int intVal;
        private boolean booleanVal;

        public MyDto(){};

        public MyDto(int intVal, String stringVal, boolean booleanVal) {
            this.intVal = intVal;
            this.stringVal = stringVal;
            this.booleanVal = booleanVal;
        }

        public String getStringVal() {
            return stringVal;
        }

        public void setStringVal(String stringVal) {
            this.stringVal = stringVal;
        }

        public int getIntVal() {
            return intVal;
        }

        public void setIntVal(int intVal) {
            this.intVal = intVal;
        }

        public boolean isBooleanVal() {
            return booleanVal;
        }

        public void setBooleanVal(boolean booleanVal) {
            this.booleanVal = booleanVal;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", MyDto.class.getSimpleName() + "[", "]")
                    .add("stringVal='" + stringVal + "'")
                    .add("intVal=" + intVal)
                    .add("booleanVal=" + booleanVal)
                    .toString();
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<MyDto> list = new ArrayList<MyDto>();
        list.add(new MyDto(1, "a", true));
        list.add(new MyDto(2, "b", false));
        String jsonArray = mapper.writeValueAsString(list);

        MyDto[] array = mapper.readValue(jsonArray, MyDto[].class);

        System.out.println("the array 0 is ["+ array[0].getClass().getSimpleName()+"]");


        List<?> asList = mapper.readValue(jsonArray, List.class);

        System.out.println("the list 0 is ["+ asList.get(0).getClass().getSimpleName()+"]");

        List<MyDto> myDtoList = mapper.readValue(jsonArray, new TypeReference<List<MyDto>>() { });

        Type superclass = myDtoList.getClass().getGenericSuperclass();

        Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];

        System.out.println("the type is "+ type);

        CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, MyDto.class);

        List<MyDto> list2 = mapper.readValue(jsonArray, javaType);

        System.out.println("the list2 0 is ["+ list2.get(0).getClass().getSimpleName()+"]");
    }
}
