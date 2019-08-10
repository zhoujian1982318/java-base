package com.example.jackson.annotation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class NodeBean {
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
//        NodeBean fromValue = new NodeBean();
//        fromValue.setId(10);
//        fromValue.setName("from value");
//
//        ObjectMapper obj = new ObjectMapper();
//        JsonNode node = obj.valueToTree(fromValue);
//        JsonNode idNode = node.get("id");
//
//        System.out.println("the id node is ["+ idNode.intValue()+"]");
//
//        String newString = "{\"nick\": \"cowtowncoder\"}";
//        JsonNode newNode = obj.readTree(newString);
//
//        System.out.println("the new  node is ["+ newNode.isContainerNode()+"]");
//        //add value
//        ObjectNode new2Node = ((ObjectNode) newNode).put("test", "test1");
//
//        JsonNode nick1Node = newNode.path("nick");
//
//        JsonNode nickNode = newNode.get("nick");
//
//        System.out.println(nick1Node.equals(nickNode));
//
//        System.out.println("the nick node is ["+ nickNode.isContainerNode()+"]");
//
//        System.out.println("the new 2 node is ["+ new2Node+"]");

          List<String> list  =new ArrayList<>();

           Type type = list.getClass().getGenericSuperclass();

           Type _type = ((ParameterizedType) type).getActualTypeArguments()[0];

           list.add("temp");
           List<Integer> list1  =new ArrayList<>();

           Type type1 = list1.getClass().getGenericSuperclass();
           Type _type1 = ((ParameterizedType) type1).getActualTypeArguments()[0];
           list1.add(1);

           List<String> list3 = new List<String>() {
               @Override
               public int size() {
                   return 0;
               }

               @Override
               public boolean isEmpty() {
                   return false;
               }

               @Override
               public boolean contains(Object o) {
                   return false;
               }

               @Override
               public Iterator<String> iterator() {
                   return null;
               }

               @Override
               public Object[] toArray() {
                   return new Object[0];
               }

               @Override
               public <T> T[] toArray(T[] a) {
                   return null;
               }

               @Override
               public boolean add(String s) {
                   return false;
               }

               @Override
               public boolean remove(Object o) {
                   return false;
               }

               @Override
               public boolean containsAll(Collection<?> c) {
                   return false;
               }

               @Override
               public boolean addAll(Collection<? extends String> c) {
                   return false;
               }

               @Override
               public boolean addAll(int index, Collection<? extends String> c) {
                   return false;
               }

               @Override
               public boolean removeAll(Collection<?> c) {
                   return false;
               }

               @Override
               public boolean retainAll(Collection<?> c) {
                   return false;
               }

               @Override
               public void clear() {

               }

               @Override
               public boolean equals(Object o) {
                   return false;
               }

               @Override
               public int hashCode() {
                   return 0;
               }

               @Override
               public String get(int index) {
                   return null;
               }

               @Override
               public String set(int index, String element) {
                   return null;
               }

               @Override
               public void add(int index, String element) {

               }

               @Override
               public String remove(int index) {
                   return null;
               }

               @Override
               public int indexOf(Object o) {
                   return 0;
               }

               @Override
               public int lastIndexOf(Object o) {
                   return 0;
               }

               @Override
               public ListIterator<String> listIterator() {
                   return null;
               }

               @Override
               public ListIterator<String> listIterator(int index) {
                   return null;
               }

               @Override
               public List<String> subList(int fromIndex, int toIndex) {
                   return null;
               }
           };

           Type type3 = list3.getClass().getGenericInterfaces()[0];
           Type _type3 = ((ParameterizedType) type3).getActualTypeArguments()[0];

            //Class<?> class1 = _type3.getClass();

           System.out.println(_type3.getClass());
    }
}
