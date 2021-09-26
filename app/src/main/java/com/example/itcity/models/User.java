package com.example.itcity.models;

public class User {
    private String name;
    int rating;

    public User() {
        this.name = name;
        this.rating = 0;
    }


    //геттер и сеттер
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(String name) {
        this.rating = rating;
    }

}
