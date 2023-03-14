package com.example.spring.demo.dtos.response;

import com.example.spring.demo.entity.User;

public class PreviewRequestDto {

    private static User user;
    private String lastname;
    private String name;
    private double military_number;
    private String state;
    private boolean validated;

    public PreviewRequestDto(String name, String lastname, String state, double military_number, boolean validated) {

        this.lastname = lastname;
        this.name = name;
        this.military_number = military_number;
        this.state = state;
        this.validated = validated;
    }




    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        PreviewRequestDto.user = user;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMilitary_number() {
        return military_number;
    }

    public void setMilitary_number(double military_number) {
        this.military_number = military_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
