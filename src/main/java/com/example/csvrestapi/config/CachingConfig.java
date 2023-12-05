/**
 * Configuration class for caching.
 */
package com.example.csvrestapi.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
    /**
     * Returns a cache manager that uses a concurrent map as the underlying store.
     * If this application will have a large amount of data or it is necessary to use distributed caching,
     * it is possible to consider other caching solutions such as EhCache, Hazelcast, Apache Ignite or Redis.
     *
     * @return a cache manager
     */
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("all_players_list", "players_list_pages", "players");
    }
}