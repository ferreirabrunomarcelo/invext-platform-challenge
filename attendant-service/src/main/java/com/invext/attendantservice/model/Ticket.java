package com.invext.attendantservice.model;

import com.invext.attendantservice.dto.TicketDTO;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private Long id;
    private String topic;
    private String message;
    private CategoryEnum category;
    private Customer customer;
    private LocalDateTime timeStamp;

    public Ticket(TicketDTO ticketDTO){
        this.id = ticketDTO.getId();
        this.topic = ticketDTO.getTopic();
        this.message = ticketDTO.getMessage();
        this.category = ticketDTO.getCategory() != null ? CategoryEnum.fromString(ticketDTO.getCategory()) : null;
        this.timeStamp = ticketDTO.getTimeStamp();
    }
}
