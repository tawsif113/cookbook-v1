package com.example.demo;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayersController {

    private final PlayerService playerService;

    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping
    public ResponseEntity<PlayerResponseBody> createPlayer(@RequestBody @Valid PlayerRequestBody playerRequestBody) {
        return ResponseEntity.ok(playerService.createPlayer(playerRequestBody));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseBody> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayer(id));
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponseBody>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

}
