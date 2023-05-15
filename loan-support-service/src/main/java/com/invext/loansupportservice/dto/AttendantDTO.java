package com.invext.loansupportservice.dto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AttendantDTO {
    private Long id;
    private String name;
    private String team;
    private boolean isAvailable;
    private List<TicketDTO> ongoingTickets;
}