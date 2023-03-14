package com.example.spring.demo.dtos.response;

public class PreviewValidatedDto {


    private int id;
    private String name;
    private String lastname;
    private double military_number;
    private boolean validated;
    private String state;

    public PreviewValidatedDto() {
    }

    public PreviewValidatedDto(int id, String name, String lastname, double military_number, boolean validated, String state) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.military_number = military_number;
        this.validated = validated;
        this.state = state;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getMilitary_number() {
        return military_number;
    }

    public void setMilitary_number(double military_number) {
        this.military_number = military_number;
    }

    public boolean isValidated() {
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
}
