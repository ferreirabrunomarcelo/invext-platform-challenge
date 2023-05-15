package com.invext.requestdistribution.service;

import com.invext.requestdistribution.dto.CustomerRequestDTO;

public interface CustomerRequestService {
    CustomerRequestDTO createCustomerRequest(CustomerRequestDTO customerRequestDTO);
}
