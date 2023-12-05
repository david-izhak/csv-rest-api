/**
 * PlayerService interface defines the contract for interacting with the player data.
 */
package com.example.csvrestapi.service;

import com.example.csvrestapi.dto.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    /**
     * Retrieves all players.
     *
     * @return a list of all players
     */
    List<Player> findAll();

    /**
     * Retrieves a subset of players with pagination.
     *
     * @param limit the maximum number of players to retrieve
     * @param offset the number of players to skip before starting to retrieve
     * @return a list of players with pagination
     */
    List<Player> findAllWithPagination(int limit, int offset);

    /**
     * Retrieves a player by their ID.
     *
     * @param id the ID of the player to retrieve
     * @return an optional player object
     */
    Optional<Player> findById(String id);
}
