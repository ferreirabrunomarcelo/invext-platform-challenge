package com.invext.attendantservice.controller;

import com.invext.attendantservice.dto.AttendantDTO;
import com.invext.attendantservice.service.AttendantService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/api/v1/attendants")
@RequiredArgsConstructor
public class AttendantController {
    private final AttendantService attendantService;

    @Cacheable("attendantsCache")
    @GetMapping("/{team}")
    public ResponseEntity<List<AttendantDTO>> getAllAvailableAttendantsByTeam(@PathVariable String team) {
        return ResponseEntity.ok(attendantService.getAllAvailableAttendantsByTeam(team));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AttendantDTO> updateAttendant(@RequestBody AttendantDTO attendantDTO,
                                                        @PathVariable("id") Long id) {
        return new ResponseEntity<>(attendantService.updateAttendant(attendantDTO, id), CREATED);
    }
}
