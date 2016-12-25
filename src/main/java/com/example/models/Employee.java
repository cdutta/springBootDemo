package com.example.models;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chinmay_dutta on 12/23/16.
 */
@Entity
public class Employee implements Serializable {

    @Id
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
