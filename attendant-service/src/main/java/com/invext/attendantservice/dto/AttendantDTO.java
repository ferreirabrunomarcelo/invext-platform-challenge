package com.invext.attendantservice.dto;

import com.invext.attendantservice.model.Attendant;
import lombok.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public AttendantDTO(Attendant attendant){
        this.id = attendant.getId();
        this.name = attendant.getName();
        this.team = attendant.getTeam().getDescription();
        this.isAvailable = attendant.isAvailable();
        this.ongoingTickets = attendant.getOngoingTickets()
                .stream()
                .map(TicketDTO::new)
                .collect(toList());
    }
}
