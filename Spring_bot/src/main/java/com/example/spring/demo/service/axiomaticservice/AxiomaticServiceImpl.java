package com.example.spring.demo.service.axiomaticservice;


import com.example.spring.demo.dtos.response.PreviewValidatedDto;
import com.example.spring.demo.entity.Request;
import com.example.spring.demo.repo.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AxiomaticServiceImpl implements AxiomaticService{



    @Autowired
    RequestRepository axiomaticRepo;

    @Override
    public List<PreviewValidatedDto> getRequestByValidated() {
        return axiomaticRepo.findByValidated(true).stream().map(request -> new PreviewValidatedDto(request.getId() ,request.getName(),
                request.getLast_name(),request.getMilitary_number(),request.getValidated(),request.getState()))
                .collect(Collectors.toList());

    }

}
