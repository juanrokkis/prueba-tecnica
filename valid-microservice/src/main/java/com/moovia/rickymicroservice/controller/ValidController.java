package com.moovia.rickymicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moovia.rickymicroservice.service.ValidService;

@RestController
@RequestMapping("/valid")
public class ValidController {

    @Autowired
    private final ValidService validServiceService;

    private static final Logger log = LoggerFactory.getLogger(ValidController.class);

    public ValidController(ValidService validServiceService) {
        this.validServiceService = validServiceService;
    }

    @GetMapping("/{card}")
    public ResponseEntity<?> getValid(@PathVariable String card) {
        ResponseEntity<?> response = this.validServiceService.valid(card);
        log.info("Service response: " + response);
        if (response.getStatusCode().isError()) {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } else {
            return ResponseEntity.ok(response.getBody());
        }
    }

}
