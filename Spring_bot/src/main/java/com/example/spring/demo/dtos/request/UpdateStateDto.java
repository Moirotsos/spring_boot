package com.example.spring.demo.dtos.request;



public class UpdateStateDto {
    private String state;

    public UpdateStateDto() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UpdateStateDto(String state) {
        this.state = state;
    }
}
