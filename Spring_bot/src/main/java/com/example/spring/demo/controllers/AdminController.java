package com.example.spring.demo.controllers;


import com.example.spring.demo.config.SecurityConfiguration;
import com.example.spring.demo.dtos.request.AddAuthorityDto;
import com.example.spring.demo.dtos.request.AddUserDto;
import com.example.spring.demo.dtos.response.AddedUserDto;
import com.example.spring.demo.dtos.response.PreviewUserDto;
import com.example.spring.demo.entity.Authority;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.repo.UserDetailsRepository;
import com.example.spring.demo.service.adminservice.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AdminController {

    @Autowired
    SecurityConfiguration securityConfiguration;
    @Autowired
    UserDetailsRepository adminRepository;

    @Autowired
    AdminService adminService;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<PreviewUserDto> retrieveAllUsers() {

        return adminService.getPreviewUsers();
    }

    @PostMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AddedUserDto> createUser(@RequestBody AddUserDto user) {

        return adminService.createUser(user);
    }

    @PostMapping("/users/addAuthority")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AddAuthorityDto> addAuthority(@RequestBody Authority auth) {
        return adminService.addAuthority(auth);
    }
    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(@PathVariable Long id) {

        adminService.deleteById(id);
    }

//    @PostMapping("/users/setAuthority")
//    public ResponseEntity<AddAuthorityDto> addAuthority(@RequestBody int id) {
//        return adminService.setAuthority(id);
//    }

}
