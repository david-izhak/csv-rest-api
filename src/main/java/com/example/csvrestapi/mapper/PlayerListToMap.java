/**
 * PlayerListToMap is a class that maps a list of players to a map using the player ID as the key and the player object as the value.
 */
package com.example.csvrestapi.mapper;

import com.example.csvrestapi.dto.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PlayerListToMap implements Mapper<List<Player>, Map<String, Player>> {

    /**
     * Maps a list of players to a map using the player ID as the key and the player object as the value.
     *
     * @param from the list of players to be mapped.
     * @return a map with the player ID as the key and the player object as the value.
     */
    @Override
    public Map<String, Player> map(List<Player> from) {
        if (from == null) {
            return Map.of();
        }
        return from.stream()
                .collect(Collectors.toMap(Player::getPlayerID, Function.identity()));
    }

}
