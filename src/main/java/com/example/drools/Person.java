package com.example.drools;

public class Person {
    private String name;
    private int age;
    private boolean isAdult;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.isAdult = false;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }
}

