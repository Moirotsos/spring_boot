package com.example.spring.demo.config;


public enum Roles {
    USER(1,"USER","User role"),
    ADMIN(2,"ADMIN","Admin role"),
    AXIOMATIC(3,"AXIOMATIC","Axiomatic role"),
    EMPLOYEE(4,"EMPLOYEE","Employee role");

    private final int id;
    private final String roleCode;
    private final String roleDescription;
    Roles(int id,String roleCode,String roleDescription) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleDescription = roleDescription;
    }

    public int getId() {
        return id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }
}
