/**
 * This is the PlayersController class which handles the REST API endpoints for players.
 * It is responsible for retrieving player data from the PlayerService.
 */
package com.example.csvrestapi.controller;

import com.example.csvrestapi.dto.Player;
import com.example.csvrestapi.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping(path = "/api/players", produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
@Slf4j
public class PlayersController {

    private final PlayerService playerService;

    /**
     * Retrieves all players.
     * If limit and offset parameters are provided, retrieves players with pagination.
     *
     * @param limit  the maximum number of players to retrieve
     * @param offset the number of players to skip
     * @return the list of players
     */
    @GetMapping()
    public ResponseEntity<List<Player>> getAllPlayers(@RequestParam(required = false) Integer limit,
                                      @RequestParam(required = false) Integer offset) {
        try {
            // Check if a client sent limit and offset. Validate input parameters
            if (limit != null && offset != null && limit > 0 && offset >= 0) {
                log.debug("Got request to get all players with limit: {} and offset: {}", limit, offset);
                return new ResponseEntity<>(playerService.findAllWithPagination(limit, offset), HttpStatus.OK);
            }
            log.debug("Got request to get all players");
            return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Unexpected error occurred when retrieving players", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves a player by their ID.
     *
     * @param id the ID of the player
     * @return the player with the specified ID
     * @throws ResponseStatusException if the player is not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Player> findPlayerById(@PathVariable String id) {
        log.debug("Got request to get player by id: {}", id);
        return playerService.findById(id)
                .map(player -> new ResponseEntity<>(player, HttpStatus.OK))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));
    }
}
