package com.example.spring.demo.dtos.request;


import com.example.spring.demo.entity.User;

public class AddRequestDto {

    private String name;
    private String last_name;
    private String military_number;
    private String state;
    User user;

    public AddRequestDto() {
    }

    public AddRequestDto(String name, String last_name, String military_number, String state, User user) {
        this.name = name;
        this.last_name = last_name;
        this.military_number = military_number;
        this.state = state;
        this.user = user;
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

    public String getMilitary_number() {
        return military_number;
    }

    public void setMilitary_number(String military_number) {
        this.military_number = military_number;
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
