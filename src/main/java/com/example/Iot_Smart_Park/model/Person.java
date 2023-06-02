package com.example.Iot_Smart_Park.model;

import com.example.Iot_Smart_Park.dao.PersonDao;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final UUID id;
    private final String username;
    private final String pass;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("username") String username,
                  @JsonProperty("pass") String pass) {
        this.id = id;
        this.username = username;
        this.pass = pass;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
