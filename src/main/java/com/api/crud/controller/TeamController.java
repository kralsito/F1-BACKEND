package com.api.crud.controller;

import com.api.crud.service.TeamService;
import com.api.crud.service.dto.request.TeamDTOin;
import com.api.crud.service.dto.response.TeamDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;


    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public ResponseEntity<TeamDTO> create(@RequestBody TeamDTOin dto) {
        TeamDTO response = teamService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<TeamDTO> getById(@PathVariable Long id) {
        TeamDTO response = teamService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<TeamDTO>> getAll() {
        List<TeamDTO> teams = teamService.getAll();
        return ResponseEntity.ok(teams);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)  {
        teamService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
