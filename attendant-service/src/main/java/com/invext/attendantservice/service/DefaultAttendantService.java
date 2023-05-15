package com.invext.attendantservice.service;

import com.invext.attendantservice.dto.AttendantDTO;
import com.invext.attendantservice.model.Attendant;
import com.invext.attendantservice.model.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class DefaultAttendantService implements AttendantService {
    private final AttendantDataLoader attendantDataLoader;

    @Override
    public List<AttendantDTO> getAllAvailableAttendantsByTeam(String team) {
        return attendantDataLoader.attendantList
                .stream()
                .filter(attendant -> attendant.isAvailable()
                        && attendant.getTeam().getDescription().equalsIgnoreCase(team))
                .map(AttendantDTO::new)
                .collect(toList());
    }

    @Override
    public AttendantDTO updateAttendant(AttendantDTO attendantDTO, Long id) {
        Attendant attendant = attendantDataLoader
                .attendantList
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);

        if (attendant.getOngoingTickets().size() < 3) {
            attendant.setOngoingTickets(attendantDTO.getOngoingTickets()
                    .stream()
                    .map(Ticket::new)
                    .collect(toList()));
            if(attendant.getOngoingTickets().size() == 3){
                attendant.setAvailable(false);
            }
        }

        return new AttendantDTO(
                attendant
        );
    }
}
