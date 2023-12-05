/**
 * This is a Java implementation of the PlayerService interface.
 * It provides methods for retrieving player data from a cache and performing pagination.
 * The service uses a PlayerListToMap mapper to convert a list of players to a map for efficient lookup.
 * Caching is implemented using the CacheableInterceptor class.
 */
package com.example.csvrestapi.service;

import com.example.csvrestapi.dto.Player;
import com.example.csvrestapi.mapper.PlayerListToMap;
import com.example.csvrestapi.service.cash.CacheableInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final PlayerListToMap playerListToMap;
    private final CacheableInterceptor cacheableInterceptor;

    /**
     * Retrieves all players from the cache if it exists.
     *
     * @return a list of all players
     */
    @Override
    public List<Player> findAll() {
        return cacheableInterceptor.getPlayerList();
    }

    /**
     * Retrieves a subset of players from the cache if it exists with pagination.
     *
     * @param limit  the maximum number of players to retrieve
     * @param offset the number of players to skip before retrieving
     * @return a list of players with the specified pagination
     */
    @Override
    @Cacheable("players_list_pages")
    public List<Player> findAllWithPagination(int limit, int offset) {
        return cacheableInterceptor.getPlayerList().stream().skip(offset).limit(limit).toList();
    }

    /**
     * Retrieves a player by their ID from the cache if it exists.
     *
     * @param id the ID of the player to retrieve
     * @return an Optional containing the player, or empty if not found
     */
    @Override
    @Cacheable("players")
    public Optional<Player> findById(String id) {
        Map<String, Player> playerMap = playerListToMap.map(cacheableInterceptor.getPlayerList());
        log.debug("Method findById didn't use the cache");
        return Optional.ofNullable(playerMap.get(id));
    }

}
