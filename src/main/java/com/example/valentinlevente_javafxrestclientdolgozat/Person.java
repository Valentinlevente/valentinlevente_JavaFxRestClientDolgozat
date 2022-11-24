package com.example.valentinlevente_javafxrestclientdolgozat;

import com.google.gson.annotations.Expose;

public class Person {
    private int id;
    @Expose
    private String name;
    @Expose
    private String city;
    @Expose
    private int age;
    @Expose
    private String phoneNumber;

    public Person(int id, String name, String city, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
