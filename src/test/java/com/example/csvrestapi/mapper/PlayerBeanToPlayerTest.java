package com.example.csvrestapi.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.csvrestapi.dto.Player;
import com.example.csvrestapi.service.storage.PlayerBean;

import java.time.LocalDate;


class PlayerBeanToPlayerTest {

    @Test
    void testMap_1() {
        PlayerBean playerBean = new PlayerBean();
        playerBean.setPlayerID("1");
        playerBean.setBirthYear("1990");
        playerBean.setBirthMonth("01");
        playerBean.setBirthDay("01");
        playerBean.setBirthCountry("USA");
        playerBean.setBirthState("NY");
        playerBean.setBirthCity("New York");
        playerBean.setDeathYear("");
        playerBean.setDeathMonth("");
        playerBean.setDeathDay("");
        playerBean.setDeathCountry("");
        playerBean.setDeathState("");
        playerBean.setDeathCity("");
        playerBean.setNameFirst("John");
        playerBean.setNameLast("Doe");
        playerBean.setNameGiven("John Doe");
        playerBean.setWeight("180.5");
        playerBean.setHeight("6.2");
        playerBean.setBats("Right");
        playerBean.setThrowsHand("Right");
        playerBean.setDebut("2010-01-01");
        playerBean.setFinalGame("2020-12-31");
        playerBean.setRetroID("RET123");
        playerBean.setBbrefID("BBR123");

        PlayerBeanToPlayer mapper = new PlayerBeanToPlayer();
        Player player = mapper.map(playerBean);

        assertEquals("1", player.getPlayerID());
        assertEquals(1990, player.getBirthYear().intValue());
        assertEquals(1, player.getBirthMonth().intValue());
        assertEquals(1, player.getBirthDay().intValue());
        assertEquals("USA", player.getBirthCountry());
        assertEquals("NY", player.getBirthState());
        assertEquals("New York", player.getBirthCity());
        assertNull(player.getDeathYear());
        assertNull(player.getDeathMonth());
        assertNull(player.getDeathDay());
        assertEquals("", player.getDeathCountry());
        assertEquals("", player.getDeathState());
        assertEquals("", player.getDeathCity());
        assertEquals("John", player.getNameFirst());
        assertEquals("Doe", player.getNameLast());
        assertEquals("John Doe", player.getNameGiven());
        assertEquals(180.5, player.getWeight(), 0.001);
        assertEquals(6.2, player.getHeight(), 0.001);
        assertEquals("Right", player.getBats());
        assertEquals("Right", player.getThrowsHand());
        assertEquals(LocalDate.parse("2010-01-01"), player.getDebut());
        assertEquals(LocalDate.parse("2020-12-31"), player.getFinalGame());
        assertEquals("RET123", player.getRetroID());
        assertEquals("BBR123", player.getBbrefID());
    }

    @Test
    void testMap_2() {
        PlayerBean playerBean = new PlayerBean();
        playerBean.setPlayerID(null);
        playerBean.setBirthYear("1990");
        playerBean.setBirthMonth("01");
        playerBean.setBirthDay("01");
        playerBean.setBirthCountry("USA");
        playerBean.setBirthState("NY");
        playerBean.setBirthCity("New York");
        playerBean.setDeathYear("");
        playerBean.setDeathMonth("");
        playerBean.setDeathDay("");
        playerBean.setDeathCountry("");
        playerBean.setDeathState("");
        playerBean.setDeathCity("");
        playerBean.setNameFirst("John");
        playerBean.setNameLast("Doe");
        playerBean.setNameGiven("John Doe");
        playerBean.setWeight("180.5");
        playerBean.setHeight("6.2");
        playerBean.setBats("Right");
        playerBean.setThrowsHand("Right");
        playerBean.setDebut("2010-01-01");
        playerBean.setFinalGame("2020-12-31");
        playerBean.setRetroID("RET123");
        playerBean.setBbrefID("BBR123");

        PlayerBeanToPlayer mapper = new PlayerBeanToPlayer();
        Player player = mapper.map(playerBean);

        assertNull(player.getPlayerID());
        assertEquals(1990, player.getBirthYear().intValue());
        assertEquals(1, player.getBirthMonth().intValue());
        assertEquals(1, player.getBirthDay().intValue());
        assertEquals("USA", player.getBirthCountry());
        assertEquals("NY", player.getBirthState());
        assertEquals("New York", player.getBirthCity());
        assertNull(player.getDeathYear());
        assertNull(player.getDeathMonth());
        assertNull(player.getDeathDay());
        assertEquals("", player.getDeathCountry());
        assertEquals("", player.getDeathState());
        assertEquals("", player.getDeathCity());
        assertEquals("John", player.getNameFirst());
        assertEquals("Doe", player.getNameLast());
        assertEquals("John Doe", player.getNameGiven());
        assertEquals(180.5, player.getWeight(), 0.001);
        assertEquals(6.2, player.getHeight(), 0.001);
        assertEquals("Right", player.getBats());
        assertEquals("Right", player.getThrowsHand());
        assertEquals(LocalDate.parse("2010-01-01"), player.getDebut());
        assertEquals(LocalDate.parse("2020-12-31"), player.getFinalGame());
        assertEquals("RET123", player.getRetroID());
        assertEquals("BBR123", player.getBbrefID());
    }
}