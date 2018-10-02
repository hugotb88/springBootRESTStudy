package com.studyrest.studyRest.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    //Members
    private Long id; // will be set when persisting
    private String firstName;
    private String lastName;
    private int age;

    public User() {
        this.id = 1L;
        this.firstName = "Victor";
        this.lastName = "Olvera";
        this.age = 31;
    }

    public User(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
