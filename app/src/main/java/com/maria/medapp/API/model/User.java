package com.maria.medapp.API.model;

/**
 * Created by Maria on 28.12.2017.
 */

public class User {

    private Integer id;
    private String name;
    private String desease;
    private String location;
    private String[] description;

    public User(String name, String desease, String location, String[] description) {
        this.name = name;
        this.desease = desease;
        this.location = location;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
}
