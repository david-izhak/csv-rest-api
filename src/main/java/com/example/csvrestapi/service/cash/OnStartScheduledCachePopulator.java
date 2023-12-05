/**
 * This class is responsible for populating the cache on application start-up.
 * It is a service class that uses the CacheableInterceptor to populate the cache.
 * The cashPopulate() method is scheduled to run at a specified initial delay.
 */
package com.example.csvrestapi.service.cash;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OnStartScheduledCachePopulator {

    private final CacheableInterceptor cacheableInterceptor;

    /**
     * Method to populate the cache.
     * It calls the getPlayerList() method of the CacheableInterceptor.
     */
    @Scheduled(initialDelayString = "${cache.populate.delay}")
    public void cachePopulate() {
        cacheableInterceptor.getPlayerList();
    }
}
