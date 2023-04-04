package com.crudjdbc;

public class Student {

    Student(){

    }

    Student(int id, String name, String email) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
    public int id;
    public String name;
    public String email;
}
