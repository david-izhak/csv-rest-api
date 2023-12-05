package com.example.csvrestapi.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

//@RunWith(SpringRunner.class)
@SpringBootTest
class CachingConfigTest {

    @Autowired
    private CacheManager cacheManager;

    @Test
    void testCacheManager() {
        assertNotNull(cacheManager);

        // Positive test case
        Cache allPlayersListCache = cacheManager.getCache("all_players_list");
        assertNotNull(allPlayersListCache);
        Cache playersListPagesCache = cacheManager.getCache("players_list_pages");
        assertNotNull(playersListPagesCache);
        Cache playersCache = cacheManager.getCache("players");
        assertNotNull(playersCache);

        // Negative test case
        Cache invalidCache = cacheManager.getCache("invalid_cache");
        assertNull(invalidCache);
    }
}