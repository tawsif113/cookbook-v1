package com.example.demo;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamsController {
    private final TeamService teamService;

    public TeamsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<TeamResponseBody> createTeam(@RequestBody @Valid TeamRequestBody teamRequestBody) {
        return ResponseEntity.ok(teamService.createTeam(teamRequestBody));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseBody> getTeam(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeamResponseBody>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

}
