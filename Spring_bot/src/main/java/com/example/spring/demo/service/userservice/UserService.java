package com.example.spring.demo.service.userservice;

import com.example.spring.demo.dtos.request.AddRequestDto;
import com.example.spring.demo.dtos.response.PreviewRequestDto;
import com.example.spring.demo.entity.Request;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;

public interface UserService {

    ResponseEntity<AddRequestDto> addRequest(Request request, Principal user);

    List<PreviewRequestDto> previewRequest(Long id);
}
