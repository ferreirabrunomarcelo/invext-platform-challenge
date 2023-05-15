package com.invext.attendantservice.dto;

import com.invext.attendantservice.model.Ticket;
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

    public TicketDTO(Ticket ticket){
        this.id = ticket.getId();
        this.topic = ticket.getTopic();
        this.message = ticket.getMessage();
        this.category = ticket.getCategory() != null ? ticket.getCategory().getDescription() : null;
        this.customerId = ticket.getCustomer() != null ? ticket.getCustomer().getId() : null;
        this.timeStamp = ticket.getTimeStamp();
    }
}
