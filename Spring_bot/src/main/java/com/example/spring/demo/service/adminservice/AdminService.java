package com.example.spring.demo.service.adminservice;


import com.example.spring.demo.dtos.request.AddAuthorityDto;
import com.example.spring.demo.dtos.request.AddUserDto;
import com.example.spring.demo.dtos.response.AddedUserDto;
import com.example.spring.demo.dtos.response.PreviewUserDto;
import com.example.spring.demo.entity.Authority;
import com.example.spring.demo.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    List<PreviewUserDto> getPreviewUsers();

    ResponseEntity<AddedUserDto> createUser(AddUserDto user);

    void deleteById( Long id);



    ResponseEntity<AddAuthorityDto> addAuthority(Authority auth);
}
