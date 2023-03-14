package com.example.spring.demo.controllers;


import com.example.spring.demo.dtos.request.UpdateStateDto;
import com.example.spring.demo.dtos.response.PreviewValidatedDto;
import com.example.spring.demo.entity.Request;
import com.example.spring.demo.repo.RequestRepository;
import com.example.spring.demo.service.axiomaticservice.AxiomaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AxiomaticController {

    @Autowired
    AxiomaticService axiomaticService;
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("/axiomatic")
    @PreAuthorize("hasAuthority('AXIOMATIC')")
    public List<PreviewValidatedDto> retrieveByValidated(){

        return  axiomaticService.getRequestByValidated();
    }

    @PutMapping("/axiomatic/{id}")
    @PreAuthorize("hasAuthority('AXIOMATIC')")
    public ResponseEntity<Object> updateState(@RequestBody UpdateStateDto updateStateDto,@PathVariable("id") int id){
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (!requestOptional.isPresent())
            return ResponseEntity.notFound().build();
        requestOptional.get().setState(updateStateDto.getState());
        requestRepository.save(requestOptional.get());
        return ResponseEntity.noContent().build();
    }

}
