package com.example.spring.demo.service.userservice;


import com.example.spring.demo.dtos.request.AddRequestDto;
import com.example.spring.demo.dtos.response.PreviewRequestDto;
import com.example.spring.demo.entity.Request;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.repo.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public ResponseEntity<AddRequestDto> addRequest(Request request, Principal user) {
        User users=(User) userDetailsService.loadUserByUsername(user.getName());
        request.setUser(users);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(request.getUser().getUsername()).toUri();
        requestRepository.save(request);
        return ResponseEntity.created(location).build();
    }

    @Override
    public List<PreviewRequestDto> previewRequest(Long id) {
        return requestRepository.findByUser(new User (id))
                .stream().map(request -> new PreviewRequestDto(request.getName(),
                        request.getLast_name(),
                        request.getState(),
                        request.getMilitary_number(),
                        request.getValidated()))
                .collect(Collectors.toList());
    }
}
