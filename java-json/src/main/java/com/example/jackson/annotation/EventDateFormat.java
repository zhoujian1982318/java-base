package com.example.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class EventDateFormat{

    private  String name;
    //only use date and calendar type
    @JsonFormat(
            shape = JsonFormat.Shape.NUMBER,
            pattern = "yyyy-MM-dd hh:mm:ss")
    private Date eventDate;

//    @JsonFormat(
//            shape = JsonFormat.Shape.NUMBER_INT,
//            pattern = "#,##")
// DateTimeFormat
    private Integer salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public static void main(String[] args) throws ParseException, JsonProcessingException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String toParse = "2014-12-20 02:30:00";
        Date date = df.parse(toParse);

        EventDateFormat event = new EventDateFormat();
        event.setEventDate(date);
        event.setName("test-json");
        event.setSalary(100000);

        String result = new ObjectMapper().setTimeZone(TimeZone.getDefault()).writeValueAsString(event);

        System.out.println("the result is ["+ result+"]");


    }
}
