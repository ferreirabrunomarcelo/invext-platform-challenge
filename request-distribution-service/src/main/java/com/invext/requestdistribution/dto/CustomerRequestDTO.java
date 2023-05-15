package com.invext.requestdistribution.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequestDTO {
    private String topic;
    private String message;
    private Long customerId;
}
