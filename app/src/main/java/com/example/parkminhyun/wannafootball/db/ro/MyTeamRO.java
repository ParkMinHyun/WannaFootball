package com.example.parkminhyun.wannafootball.db.ro;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ParkMinHyun on 2018-03-11.
 */

public class MyTeamRO extends RealmObject{

    @PrimaryKey
    private int teamID;

    private String teamName;
    private String teamLogoURL;
    private int teamScore;
    private int teamAge;
    private int teamNumber;
    private String teamArea;
    private String teamInfoMessage;

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLogoURL() {
        return teamLogoURL;
    }

    public void setTeamLogoURL(String teamLogoURL) {
        this.teamLogoURL = teamLogoURL;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public int getTeamAge() {
        return teamAge;
    }

    public void setTeamAge(int teamAge) {
        this.teamAge = teamAge;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getTeamArea() {
        return teamArea;
    }

    public void setTeamArea(String teamArea) {
        this.teamArea = teamArea;
    }

    public String getTeamInfoMessage() {
        return teamInfoMessage;
    }

    public void setTeamInfoMessage(String teamInfoMessage) {
        this.teamInfoMessage = teamInfoMessage;
    }
}
