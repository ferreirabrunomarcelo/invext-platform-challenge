package com.invext.requestdistribution.controller;

import com.invext.requestdistribution.dto.CustomerRequestDTO;
import com.invext.requestdistribution.service.CustomerRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/customer-requests")
@RequiredArgsConstructor
public class CustomerRequestController {
    private final CustomerRequestService customerRequestService;

    @PostMapping
    public ResponseEntity<CustomerRequestDTO> createCustomerRequest(@RequestBody CustomerRequestDTO customerRequestDTO){
        return new ResponseEntity<>(customerRequestService.createCustomerRequest(customerRequestDTO), CREATED);
    }
}
