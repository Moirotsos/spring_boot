package com.example.spring.demo.controllers;

import com.example.spring.demo.dtos.request.AddRequestDto;
import com.example.spring.demo.dtos.response.PreviewRequestDto;
import com.example.spring.demo.entity.Request;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.repo.RequestRepository;
import com.example.spring.demo.repo.UserDetailsRepository;
import com.example.spring.demo.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    UserDetailsRepository adminRepository;

    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddRequestDto> createRequest(@RequestBody Request request, Principal user){

        return userService.addRequest(request,user);

    }

    @GetMapping("/user/{id}")
    public List<PreviewRequestDto> previewRequests(@PathVariable("id") Long id) {
        return userService.previewRequest(id);
    }
}
