package com.example.csvrestapi.controller;

import com.example.csvrestapi.dto.Player;
import com.example.csvrestapi.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayersControllerTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayersController playersController;

    @Test
    void shouldFetchAllPlayersWithPagination() {
        ResponseEntity<List<Player>> response = playersController.getAllPlayers(10, 0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(emptyList(), response.getBody());
    }

    @Test
    void shouldFetchAllPlayersWithoutPagination() {
        ResponseEntity<List<Player>> response = playersController.getAllPlayers(null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(emptyList(), response.getBody());
    }

    @Test
    void shouldFetchPlayerById() {
        Player player = new Player();
        String playerId = "id1";
        player.setPlayerID(playerId);
        when(playerService.findById(playerId)).thenReturn(Optional.of(player));

        ResponseEntity<Player> response = playersController.findPlayerById(playerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(player, response.getBody());
    }

    @Test
    void shouldThrowErrorWhenPlayerIsNotFound() {
        String playerId = "non_existent_id";
        when(playerService.findById(playerId)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> playersController.findPlayerById(playerId));
    }
}