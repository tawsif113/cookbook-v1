package com.example.demo.service;


import com.example.demo.model.PlayerRequestBody;
import com.example.demo.model.PlayerResponseBody;
import com.example.demo.model.Players;
import com.example.demo.model.Teams;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TeamRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public PlayerResponseBody createPlayer(@Valid PlayerRequestBody playerRequestBody) {

        Players player = new Players();
        player.setName(playerRequestBody.getName());

        Teams team = teamRepository.findById(playerRequestBody.getTeamId())
                .orElseThrow(() -> new RuntimeException("Team not found"));

        player.setTeam(team);
        Players savedPlayer = playerRepository.save(player);
        PlayerResponseBody playerResponseBody = new PlayerResponseBody();
        playerResponseBody.setId(savedPlayer.getId());
        playerResponseBody.setName(savedPlayer.getName());
        playerResponseBody.setTeamName(team.getName());
        return playerResponseBody;

    }

    public PlayerResponseBody getPlayer(Long id) {

        Players player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        PlayerResponseBody playerResponseBody = new PlayerResponseBody();
        playerResponseBody.setId(player.getId());
        playerResponseBody.setName(player.getName());
        playerResponseBody.setTeamName(player.getTeam().getName());
        return playerResponseBody;

    }

    public List<PlayerResponseBody> getAllPlayers() {
        List<Players> players = playerRepository.findAll();
        return players.stream().map(player -> {
            PlayerResponseBody playerResponseBody = new PlayerResponseBody();
            playerResponseBody.setId(player.getId());
            playerResponseBody.setName(player.getName());
            playerResponseBody.setTeamName(player.getTeam().getName());
            return playerResponseBody;
        }).toList();
    }
}
