package com.example.csvrestapi.service.cash;

import com.example.csvrestapi.dto.Player;
import com.example.csvrestapi.mapper.PlayerBeanToPlayer;
import com.example.csvrestapi.service.storage.PlayerBean;
import com.example.csvrestapi.service.storage.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CacheableInterceptorTest {
    private CacheableInterceptor cacheableInterceptor;
    @Mock
    private PlayerBeanToPlayer playerBeanToPlayer;
    @Mock
    private StorageService storageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cacheableInterceptor = new CacheableInterceptor(playerBeanToPlayer, storageService);
    }

    @Test
    void getPlayerList_WhenCacheEmpty_ReturnsPlayerListFromStorageService() {
        // Arrange
        List<PlayerBean> playerBeans = List.of(
                PlayerBean.builder().nameFirst(("John")).nameLast(("Doe")).build(),
                PlayerBean.builder().nameFirst("Jane").nameLast("Smith").build());
        List<Player> expectedPlayers = List.of(
                Player.builder().nameFirst(("John")).nameLast(("Doe")).build(),
                Player.builder().nameFirst("Jane").nameLast("Smith").build());
        when(storageService.readAllData()).thenReturn(playerBeans);
        when(playerBeanToPlayer.map(any(PlayerBean.class))).thenReturn(new Player());

        // Act
        List<Player> actualPlayers = cacheableInterceptor.getPlayerList();

        // Assert
        assertEquals(expectedPlayers.size(), actualPlayers.size());
        verify(storageService, times(1)).readAllData();
        verify(playerBeanToPlayer, times(playerBeans.size())).map(any(PlayerBean.class));
    }

}