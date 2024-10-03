package com.api.streamapi;

import jakarta.persistence.Entity;



public class Employee {

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }




}
