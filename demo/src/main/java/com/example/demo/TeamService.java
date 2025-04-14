package com.example.demo;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public TeamResponseBody createTeam(@Valid TeamRequestBody teamRequestBody) {
        Teams teams = new Teams();
        teams.setName(teamRequestBody.getName());
        Teams Teams = teamRepository.save(teams);
        TeamResponseBody teamResponseBody = new TeamResponseBody();
        teamResponseBody.setId(Teams.getId());
        teamResponseBody.setName(Teams.getName());
        return teamResponseBody;
    }

    public TeamResponseBody getTeamById(Long id) {

        Teams teams = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
        TeamResponseBody teamResponseBody = new TeamResponseBody();
        teamResponseBody.setId(teams.getId());
        teamResponseBody.setName(teams.getName());
        return teamResponseBody;
    }

    public List<TeamResponseBody> getAllTeams() {
        List<Teams> teamsList = teamRepository.findAll();
        return teamsList.stream().map(teams -> {
            TeamResponseBody teamResponseBody = new TeamResponseBody();
            teamResponseBody.setId(teams.getId());
            teamResponseBody.setName(teams.getName());
            return teamResponseBody;
        }).toList();
    }
}
