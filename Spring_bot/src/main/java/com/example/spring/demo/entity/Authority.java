package com.example.spring.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import static org.assertj.core.api.Assertions.assertThat;
import javax.persistence.*;


@Table(name = "auth_authority")
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_description")
    private String roleDescription;

    public Authority() {
    }

    public Authority(String roleCode, String roleDescription) {
        this.roleCode = roleCode;
        this.roleDescription = roleDescription;
    }

    public Authority(int id, String roleCode, String roleDescription) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleDescription = roleDescription;
    }

    public Authority(String roleCode) {
        this.roleCode = roleCode;
    }

    public Authority(int id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return roleCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
