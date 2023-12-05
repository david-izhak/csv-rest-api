package com.example.csvrestapi.service.cash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class OnStartScheduledCachePopulatorTest {

    @Mock
    private CacheableInterceptor cacheableInterceptor;

    private OnStartScheduledCachePopulator cachePopulator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cachePopulator = new OnStartScheduledCachePopulator(cacheableInterceptor);
    }

    @Test
    void testCachePopulate() {
        cachePopulator.cachePopulate();
        verify(cacheableInterceptor, times(1)).getPlayerList();
    }

}