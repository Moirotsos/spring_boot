package com.example.spring.demo.controllers;


import com.example.spring.demo.dtos.request.UpdateRequestDto;
import com.example.spring.demo.entity.Request;
import com.example.spring.demo.repo.RequestRepository;
import com.example.spring.demo.service.employeservice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public List<Request> retrieveAllRequest() {

        return employeeService.retrieveAllRequest();
        //return requestRepository.findAll();
    }

    @PutMapping("/employee/{id}")
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public ResponseEntity<Object> updateRequest(@RequestBody UpdateRequestDto updateRequestDto, @PathVariable("id") int id){

        Optional<Request> requestOptional = requestRepository.findById(id);

        if (!requestOptional.isPresent())
            return ResponseEntity.notFound().build();
        requestOptional.get().setValidated(updateRequestDto.isValidated());

        requestRepository.save(requestOptional.get());

        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/employee/{id}")
    @PreAuthorize("hasAuthority('EMPLOYEE')")
    public void deleteRequset(@PathVariable("id") int id) {

        requestRepository.deleteById(id);
    }

}
