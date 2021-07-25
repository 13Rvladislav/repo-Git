package com.example.itcity.models;

public class User {
    private String name, email, codeword;
    int pass;

    public User() {

    }

    //конструктор
    public User(String name, String email, int pass, String codeword) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.codeword=codeword;
    }

        //геттер и сеттер
    //Имя
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //почта
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //пароль
    public int getPass() {
        return pass;
    }
    public void setPass(int pass) {
        this.pass = pass;
    }
    //кодовое слово
    public String getcodeword() {
        return codeword;
    }
    public void setcodeword(String codeword) {
        this.codeword = codeword;
    }


}
