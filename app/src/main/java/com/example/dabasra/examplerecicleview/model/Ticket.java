package com.example.dabasra.examplerecicleview.model;

/**
 * Created by dabasra .
 */
public class Ticket {


    private String title;
    private String day;
    private String url;

    public Ticket(String title , String day, String url) {
        this.title = title;
        this.day = day;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDay() {
        return day;
    }

    public String getUrl() {
        return url;
    }
}
