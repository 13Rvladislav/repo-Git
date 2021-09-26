package com.example.itcity.models;

public class Users {
    String name;
    int rating;

    public Users() {

    }

    public Users(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    // public Map<String, Object> toMap() {

    //  }
}
