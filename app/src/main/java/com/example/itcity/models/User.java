package com.example.itcity.models;

public class User {
    private String name, email;
    int pass;

    public User() {

    }

    //конструктор
    public User(String name, String email, int pass, String phone) {
        this.name = name;
        this.email = email;
        this.pass = pass;

    }

    //геттер и сеттер
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }


}
