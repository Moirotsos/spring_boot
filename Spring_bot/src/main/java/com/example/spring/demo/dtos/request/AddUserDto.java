package com.example.spring.demo.dtos.request;

import com.example.spring.demo.entity.Authority;


import java.util.List;

public class AddUserDto {

    private String userName;
    private String password;
    private boolean enabled;
    private List<Integer> rolesId ;

    public AddUserDto() {
    }

    public AddUserDto(String userName, String password, boolean enabled,List<Integer> rolesId) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.rolesId = rolesId ;

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<Integer> getRolesId() {
        return rolesId;
    }
}
