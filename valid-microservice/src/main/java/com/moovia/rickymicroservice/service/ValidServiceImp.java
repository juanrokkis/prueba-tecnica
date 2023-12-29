package com.moovia.rickymicroservice.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.moovia.rickymicroservice.service.dto.Information;
import com.moovia.rickymicroservice.util.ResponseInfo;

@Service
public class ValidServiceImp extends AbstractClient implements ValidService {

    public ValidServiceImp(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public ResponseEntity<?> valid(String card) {
        ResponseInfo responseInfo;
        String uri = baseUrl + "/valid/" + card;
        HttpEntity<Void> requestEntity = new HttpEntity<>(this.buildAuthToken());
        try {
            ResponseEntity<Information> response = restTemplate.exchange(
                    uri, HttpMethod.GET, requestEntity, Information.class);

            if (!response.getStatusCode().isError()) {
                responseInfo = new ResponseInfo("Operacion exitosa", response.getStatusCode().value());
                return ResponseEntity.ok(response.getBody());
            } else {
                responseInfo = new ResponseInfo("Error", response.getStatusCode().value());
                return ResponseEntity.status(response.getStatusCode()).body(responseInfo);
            }
        } catch (HttpClientErrorException.Conflict ex) {
            responseInfo = new ResponseInfo("Error: Tarjeta invalida", HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(responseInfo);
        }
    }

}
