/**
 * Player class represents a player in a baseball team.
 * It contains various attributes such as player ID, birth date, death date,
 * name, weight, height, batting style, throwing hand, debut date, and final game date.
 */
package com.example.csvrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
    // Fields representing player information
    private String playerID;

    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;

    private Integer deathYear;
    private Integer deathMonth;
    private Integer deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;

    private String nameFirst;
    private String nameLast;
    private String nameGiven;

    private Double weight;
    private Double height;

    private String bats;
    private String throwsHand;
    private LocalDate debut;
    private LocalDate finalGame;

    private String retroID;
    private String bbrefID;

}
