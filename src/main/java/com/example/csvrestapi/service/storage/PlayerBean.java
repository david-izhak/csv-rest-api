package com.example.csvrestapi.service.storage;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerBean {
    @CsvBindByName(column = "playerID")
    private String playerID;
    @CsvBindByName(column = "birthYear")
    private String birthYear;
    @CsvBindByName(column = "birthMonth")
    private String birthMonth;
    @CsvBindByName(column = "birthDay")
    private String birthDay;
    @CsvBindByName(column = "birthCountry")
    private String birthCountry;
    @CsvBindByName(column = "birthState")
    private String birthState;
    @CsvBindByName(column = "birthCity")
    private String birthCity;
    @CsvBindByName(column = "deathYear")
    private String deathYear;
    @CsvBindByName(column = "deathMonth")
    private String deathMonth;
    @CsvBindByName(column = "deathDay")
    private String deathDay;
    @CsvBindByName(column = "deathCountry")
    private String deathCountry;
    @CsvBindByName(column = "deathState")
    private String deathState;
    @CsvBindByName(column = "deathCity")
    private String deathCity;
    @CsvBindByName(column = "nameFirst")
    private String nameFirst;
    @CsvBindByName(column = "nameLast")
    private String nameLast;
    @CsvBindByName(column = "nameGiven")
    private String nameGiven;
    @CsvBindByName(column = "weight")
    private String weight;
    @CsvBindByName(column = "height")
    private String height;
    @CsvBindByName(column = "bats")
    private String bats;
    @CsvBindByName(column = "throws")
    private String throwsHand;
    @CsvBindByName(column = "debut")
    private String debut;
    @CsvBindByName(column = "finalGame")
    private String finalGame;
    @CsvBindByName(column = "retroID")
    private String retroID;
    @CsvBindByName(column = "bbrefID")
    private String bbrefID;

}
