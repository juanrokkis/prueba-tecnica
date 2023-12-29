package com.moovia.rickymicroservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface InformationService {
    ResponseEntity<?> getInformation(String card);
}
