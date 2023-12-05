/**
 * This class is responsible for mapping a PlayerBean object to a Player object.
 */
package com.example.csvrestapi.mapper;

import com.example.csvrestapi.dto.Player;
import com.example.csvrestapi.service.storage.PlayerBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PlayerBeanToPlayer implements Mapper<PlayerBean, Player> {

    /**
     * Maps a PlayerBean object to a Player object.
     *
     * @param playerBean The PlayerBean object to be mapped.
     * @return The mapped Player object.
     */
    public Player map(PlayerBean playerBean) {
        Player player = new Player();
        // Mapping properties
        player.setPlayerID(playerBean.getPlayerID());
        player.setBirthYear(playerBean.getBirthYear().isBlank() ? null : Integer.parseInt(playerBean.getBirthYear()));
        player.setBirthMonth(playerBean.getBirthMonth().isBlank() ? null : Integer.parseInt(playerBean.getBirthMonth()));
        player.setBirthDay(playerBean.getBirthDay().isBlank() ? null : Integer.parseInt(playerBean.getBirthDay()));
        player.setBirthCountry(playerBean.getBirthCountry());
        player.setBirthState(playerBean.getBirthState());
        player.setBirthCity(playerBean.getBirthCity());
        player.setDeathYear(playerBean.getDeathYear().isBlank() ? null : Integer.parseInt(playerBean.getDeathYear()));
        player.setDeathMonth(playerBean.getDeathMonth().isBlank() ? null : Integer.parseInt(playerBean.getDeathMonth()));
        player.setDeathDay(playerBean.getDeathDay().isBlank() ? null : Integer.parseInt(playerBean.getDeathDay()));
        player.setDeathCountry(playerBean.getDeathCountry());
        player.setDeathState(playerBean.getDeathState());
        player.setDeathCity(playerBean.getDeathCity());
        player.setNameFirst(playerBean.getNameFirst());
        player.setNameLast(playerBean.getNameLast());
        player.setNameGiven(playerBean.getNameGiven());
        player.setWeight(playerBean.getWeight().isBlank() ? null : Double.parseDouble(playerBean.getWeight()));
        player.setHeight(playerBean.getHeight().isBlank() ? null : Double.parseDouble(playerBean.getHeight()));
        player.setBats(playerBean.getBats());
        player.setThrowsHand(playerBean.getThrowsHand());
        player.setDebut(playerBean.getDebut().isBlank() ? null : LocalDate.parse(playerBean.getDebut()));
        player.setFinalGame(playerBean.getFinalGame().isBlank() ? null : LocalDate.parse(playerBean.getFinalGame()));
        player.setRetroID(playerBean.getRetroID());
        player.setBbrefID(playerBean.getBbrefID());
        return player;
    }

}