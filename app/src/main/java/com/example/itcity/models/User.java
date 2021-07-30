package com.example.itcity.models;

public class User {
    private String name, email;
    int pass,raiting;

    public User() {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.raiting=0;
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

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(String name) {
        this.raiting = raiting;
    }

}
