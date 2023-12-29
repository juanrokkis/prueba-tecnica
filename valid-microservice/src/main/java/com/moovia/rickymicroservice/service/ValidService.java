package com.moovia.rickymicroservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ValidService {
    ResponseEntity<?> valid(String card);
}
