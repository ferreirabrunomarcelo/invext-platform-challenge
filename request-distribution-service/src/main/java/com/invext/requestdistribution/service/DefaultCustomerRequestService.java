package com.invext.requestdistribution.service;

import com.invext.requestdistribution.dto.CustomerRequestDTO;
import com.invext.requestdistribution.model.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Service
@RequiredArgsConstructor
public class DefaultCustomerRequestService implements CustomerRequestService {
    private final KafkaTemplate<String, CustomerRequest> kafkaTemplate;

    @Override
    public CustomerRequestDTO createCustomerRequest(CustomerRequestDTO customerRequestDTO) {
        CustomerRequest customerRequest = CustomerRequest.builder()
                .topic(customerRequestDTO.getTopic())
                .message(customerRequestDTO.getMessage())
                .customerId(customerRequestDTO.getCustomerId())
                .build();

        ProducerRecord<String, CustomerRequest> record = new ProducerRecord<>(determineKafkaTopic(customerRequest),
                customerRequest.getCustomerId().toString(),
                customerRequest);

        kafkaTemplate.send(record);

        return customerRequestDTO;
    }

    public String determineKafkaTopic(CustomerRequest request) {
        Map<String, String> topics = new HashMap<>();
        topics.put("Problemas com cartão", "card-support");
        topics.put("contratação de empréstimo", "loan-support");

        String defaultTopic = "other-support";

        for (Entry<String, String> entry : topics.entrySet()) {
            if (request.getTopic().contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return defaultTopic;
    }
}
