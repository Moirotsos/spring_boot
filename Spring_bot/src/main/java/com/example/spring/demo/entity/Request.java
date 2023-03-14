package com.example.spring.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "request")
@Entity
public class Request implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "military_number")
    private double military_number;
    @Column(name = "validated")
    private boolean validated;
    @Column(name = "state")
    private String state;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinColumn(name = "user_name", nullable = false)
    private User user;

    public Request() {
    }
    public Request(String name, String last_name, double military_number, boolean validated, String state, User user) {
        super();
        this.name = name;
        this.last_name = last_name;
        this.military_number = military_number;
        this.validated = validated;
        this.state = state;
        this.user = user;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getMilitary_number() {
        return military_number;
    }

    public void setMilitary_number(double military_number) {
        this.military_number = military_number;
    }

    public boolean getValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
