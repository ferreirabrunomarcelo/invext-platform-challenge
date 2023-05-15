package com.invext.attendantservice.model;

import com.invext.attendantservice.dto.AttendantDTO;
import lombok.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Attendant {
    private Long id;
    private String name;
    private TeamEnum team;
    private boolean isAvailable;
    private List<Ticket> ongoingTickets;

    public Attendant(AttendantDTO attendantDTO){
        this.id = attendantDTO.getId();
        this.name = attendantDTO.getName();
        this.team = attendantDTO.getTeam() != null ? TeamEnum.fromString(attendantDTO.getTeam()) : null;
        this.isAvailable = attendantDTO.isAvailable();
        this.ongoingTickets = attendantDTO.getOngoingTickets()
                .stream()
                .map(Ticket::new)
                .collect(toList());
    }
}
