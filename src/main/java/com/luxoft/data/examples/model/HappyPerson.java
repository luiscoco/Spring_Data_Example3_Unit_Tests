package com.luxoft.data.examples.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HappyPerson extends Person {

    @Column(name = "MOOD")
    private String mood;

    public HappyPerson() {
        this.mood = "happy";
    }

    public HappyPerson(String name) {
        this.mood = "happy";
        setName(name);
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "HappyPerson{" +
                "name='" + getName() + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }
}
