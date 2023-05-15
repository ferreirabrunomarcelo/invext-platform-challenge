package com.invext.attendantservice.service;

import com.invext.attendantservice.dto.AttendantDTO;

import java.util.List;

public interface AttendantService {
    List<AttendantDTO> getAllAvailableAttendantsByTeam(String team);
    AttendantDTO updateAttendant(AttendantDTO attendantDTO, Long id);
}
