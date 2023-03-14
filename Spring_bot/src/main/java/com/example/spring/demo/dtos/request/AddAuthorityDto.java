package com.example.spring.demo.dtos.request;


import com.example.spring.demo.entity.Authority;

public class AddAuthorityDto {

    private Authority createAuthority(String roleCode,String roleDescription) {
        Authority authority=new Authority();
        authority.setRoleCode(roleCode);
        authority.setRoleDescription(roleDescription);
        return authority;
    }

}
