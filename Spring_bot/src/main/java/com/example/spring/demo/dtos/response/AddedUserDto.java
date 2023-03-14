package com.example.spring.demo.dtos.response;

import com.example.spring.demo.entity.Authority;

import java.util.List;

public class AddedUserDto {

    private String userName;

    private boolean enabled;
    private List<Authority> authority;

    public AddedUserDto() {
    }

    public AddedUserDto(String userName,  boolean enabled, List<Authority> authority) {
        this.userName = userName;

        this.enabled = enabled;
        this.authority = authority;
    }

    public AddedUserDto(String userName,  boolean enabled) {
        this.userName = userName;

        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }
}
