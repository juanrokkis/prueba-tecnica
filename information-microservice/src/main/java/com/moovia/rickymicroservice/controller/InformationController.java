package com.moovia.rickymicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moovia.rickymicroservice.service.InformationService;

@RestController
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private final InformationService informationServiceService;

    private static final Logger log = LoggerFactory.getLogger(InformationController.class);

    public InformationController(InformationService informationServiceService) {
        this.informationServiceService = informationServiceService;
    }

    @GetMapping("/{card}")
    public ResponseEntity<?> getInformation(@PathVariable String card) {
        ResponseEntity<?> response = this.informationServiceService.getInformation(card);
        log.info("Service response: " + response);
        if (response.getStatusCode().isError()) {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } else {
            return ResponseEntity.ok(response.getBody());
        }
    }

}
