package com.example.csvrestapi.mapper;

import com.example.csvrestapi.dto.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayerListToMapTest {

    private PlayerListToMap playerListToMap;

    @BeforeEach
    public void setUp() {
        playerListToMap = new PlayerListToMap();
    }

    @Test
    void testMap_PositiveCase() {
        Player player1 = new Player();
        player1.setPlayerID("1");
        player1.setNameFirst("John");
        Player player2 = new Player();
        player2.setPlayerID("2");
        player2.setNameFirst("Jane");
        List<Player> playerList = Arrays.asList(player1, player2);

        Map<String, Player> expectedMap = new HashMap<>();
        expectedMap.put("1", player1);
        expectedMap.put("2", player2);

        Map<String, Player> actualMap = playerListToMap.map(playerList);

        assertEquals(expectedMap, actualMap);
    }

    @Test
    void testMap_EmptyList() {
        List<Player> playerList = Arrays.asList();

        Map<String, Player> expectedMap = new HashMap<>();

        Map<String, Player> actualMap = playerListToMap.map(playerList);

        assertEquals(expectedMap, actualMap);
    }

    @Test
    void testMap_NullList() {
        List<Player> playerList = null;

        Map<String, Player> expectedMap = Map.of();

        Map<String, Player> actualMap = playerListToMap.map(playerList);

        assertEquals(expectedMap, actualMap);
    }
}