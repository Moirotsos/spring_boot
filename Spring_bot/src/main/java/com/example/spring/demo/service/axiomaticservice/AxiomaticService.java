package com.example.spring.demo.service.axiomaticservice;


import com.example.spring.demo.dtos.response.PreviewValidatedDto;
import com.example.spring.demo.entity.Request;

import java.util.List;

public interface AxiomaticService {

    List<PreviewValidatedDto> getRequestByValidated();
}
