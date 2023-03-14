package com.example.spring.demo.dtos.request;



public class UpdateRequestDto {

    private boolean validated;

    public UpdateRequestDto() {
    }

    public UpdateRequestDto(boolean validated) {
        this.validated = validated;
    }

    public boolean isValidated() {
        return validated;
    }
}
