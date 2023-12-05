package com.example.csvrestapi.service;

import com.example.csvrestapi.dto.Player;
import com.example.csvrestapi.mapper.PlayerListToMap;
import com.example.csvrestapi.service.cash.CacheableInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class PlayerServiceImplTest {

    private PlayerServiceImpl playerService;

    @Mock
    private PlayerListToMap playerListToMap;

    @Mock
    private CacheableInterceptor cacheableInterceptor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playerService = new PlayerServiceImpl(playerListToMap, cacheableInterceptor);
    }

    @Test
    void testFindAll() {
        // Mock the cacheableInterceptor to return a list of players
        List<Player> expectedPlayers = Arrays.asList(
                Player.builder().playerID("aaa").nameFirst(("John")).nameLast(("Doe")).build(),
                Player.builder().playerID("bbb").nameFirst("Jane").nameLast("Smith").build());
        when(cacheableInterceptor.getPlayerList()).thenReturn(expectedPlayers);

        // Call the findAll method
        List<Player> actualPlayers = playerService.findAll();

        // Verify that the returned list of players matches the expected list
        assertEquals(expectedPlayers, actualPlayers);

        // Verify that the getPlayerList method of cacheableInterceptor is called once
        verify(cacheableInterceptor, times(1)).getPlayerList();
    }

    @Test
    void testFindAllWithPagination() {
        // Mock the cacheableInterceptor to return a list of players
        List<Player> allPlayers = Arrays.asList(
                Player.builder().playerID("aaa").nameFirst(("John")).nameLast(("Doe")).build(),
                Player.builder().playerID("bbb").nameFirst("Jane").nameLast("Smith").build(),
                Player.builder().playerID("ccc").nameFirst("Mike").nameLast("Brown").build());
        when(cacheableInterceptor.getPlayerList()).thenReturn(allPlayers);

        // Set the pagination parameters
        int limit = 2;
        int offset = 1;

        // Call the findAllWithPagination method
        List<Player> actualPlayers = playerService.findAllWithPagination(limit, offset);

        // Verify that the returned list of players matches the expected list
        List<Player> expectedPlayers = Arrays.asList(
                Player.builder().playerID("bbb").nameFirst("Jane").nameLast("Smith").build(),
                Player.builder().playerID("ccc").nameFirst("Mike").nameLast("Brown").build()
        );
        assertEquals(expectedPlayers, actualPlayers);

        // Verify that the getPlayerList method of cacheableInterceptor is called once
        verify(cacheableInterceptor, times(1)).getPlayerList();
    }

    @Test
    void testFindById() {
        // Mock the cacheableInterceptor to return a list of players
        List<Player> allPlayers = Arrays.asList(
                Player.builder().playerID("aaa").nameFirst(("John")).nameLast(("Doe")).build(),
                Player.builder().playerID("bbb").nameFirst("Jane").nameLast("Smith").build(),
                Player.builder().playerID("ccc").nameFirst("Mike").nameLast("Brown").build()
        );
        when(cacheableInterceptor.getPlayerList()).thenReturn(allPlayers);

        // Mock the playerListToMap to return a map of players
        Map<String, Player> playerMap = Map.of(
                "aaa", Player.builder().playerID("aaa").nameFirst(("John")).nameLast(("Doe")).build(),
                "bbb", Player.builder().playerID("bbb").nameFirst("Jane").nameLast("Smith").build(),
                "ccc", Player.builder().playerID("ccc").nameFirst("Mike").nameLast("Brown").build()
        );
        when(playerListToMap.map(allPlayers)).thenReturn(playerMap);

        // Set the ID of the player to retrieve
        String id = "bbb";

        // Call the findById method
        Optional<Player> actualPlayer = playerService.findById(id);

        // Verify that the returned Optional contains the expected player
        Player expectedPlayer = Player.builder().playerID("bbb").nameFirst("Jane").nameLast("Smith").build();
        assertTrue(actualPlayer.isPresent());
        assertEquals(expectedPlayer, actualPlayer.get());

        // Verify that the getPlayerList method of cacheableInterceptor is called once
        verify(cacheableInterceptor, times(1)).getPlayerList();

        // Verify that the map method of playerListToMap is called once
        verify(playerListToMap, times(1)).map(allPlayers);
    }
}