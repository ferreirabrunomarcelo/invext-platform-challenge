package com.invext.cardsupportservice.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {
    private String topic;
    private String message;
    private Long customerId;
}