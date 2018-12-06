package com.rentaladda.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "User")
public class User implements Serializable {

    public static final long serialVersionUID = 42L;
   // @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
