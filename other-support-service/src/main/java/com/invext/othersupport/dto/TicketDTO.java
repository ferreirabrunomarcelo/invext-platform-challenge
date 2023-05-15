package com.invext.othersupport.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDTO {
    private Long id;
    private String topic;
    private String message;
    private String category;
    private Long customerId;
    private LocalDateTime timeStamp;
}
