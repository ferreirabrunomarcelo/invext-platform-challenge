package com.invext.othersupport.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invext.othersupport.dto.AttendantDTO;
import com.invext.othersupport.dto.TicketDTO;
import com.invext.othersupport.model.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.http.HttpMethod.PUT;

@Component
@RequiredArgsConstructor
public class KafkaListeners {
    private final RestTemplate restTemplate;
    private List<AttendantDTO> availableAttendants = new ArrayList<>();
    private List<CustomerRequest> waitingQueue = new LinkedList<>();

    @Scheduled(fixedDelay = 5000)
    private void getAvailableAttendants() {
        String url = "http://localhost:8080/api/v1/attendants/other";

        ResponseEntity<AttendantDTO[]> response = restTemplate.getForEntity(url, AttendantDTO[].class);

        availableAttendants = Arrays.asList(response.getBody());
    }

    @Scheduled(fixedDelay = 5000)
    private void assignTicketToAttendantFromWaitingQueue() {
        if (!waitingQueue.isEmpty() && availableAttendants.size() > 0) {
            CustomerRequest customerRequest = waitingQueue.remove(0);
            assignTicketToAttendant(customerRequest);
        }
    }

    @KafkaListener(topics = "other-support", groupId = "other")
    public void receiveMessage(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerRequest customerRequest = objectMapper.readValue(consumerRecord.value(), CustomerRequest.class);

        if (availableAttendants.isEmpty()) {
            waitingQueue.add(customerRequest);
        } else {
            assignTicketToAttendant(customerRequest);
        }
    }

    private void assignTicketToAttendant(CustomerRequest customerRequest) {
        AttendantDTO attendant = availableAttendants.stream().findFirst().orElse(null);

        if (attendant != null) {
            attendant.getOngoingTickets()
                    .add(TicketDTO
                            .builder()
                            .customerId(customerRequest.getCustomerId())
                            .build());
            String url = "http://localhost:8080/api/v1/attendants/" + attendant.getId();

            HttpEntity<AttendantDTO> requestEntity = new HttpEntity<>(attendant);

            restTemplate.exchange(url, PUT, requestEntity, AttendantDTO.class);
        }
    }
}