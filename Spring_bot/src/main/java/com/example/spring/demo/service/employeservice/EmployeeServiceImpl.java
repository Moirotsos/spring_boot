package com.example.spring.demo.service.employeservice;


import com.example.spring.demo.entity.Request;
import com.example.spring.demo.repo.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> retrieveAllRequest() {
        return requestRepository.findAll();
    }
}
