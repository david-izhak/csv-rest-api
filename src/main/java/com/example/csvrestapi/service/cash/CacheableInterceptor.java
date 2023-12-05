/**
 * This class is an interceptor that provides caching functionality for the getPlayerList method.
 */
package com.example.csvrestapi.service.cash;

import com.example.csvrestapi.dto.Player;
import com.example.csvrestapi.mapper.PlayerBeanToPlayer;
import com.example.csvrestapi.service.storage.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CacheableInterceptor {

    private final PlayerBeanToPlayer playerBeanToPlayer;
    private final StorageService storageService;

    /**
     * Retrieves the list of players from the cache or reads from the storage service if not present in the cache.
     *
     * @return The list of players.
     */
    @Cacheable("all_players_list")
    public List<Player> getPlayerList() {
        log.debug("Method getPlayerList didn't use the cash");
        return storageService.readAllData().stream()
                .map(playerBeanToPlayer::map)
                .toList();
    }
}
