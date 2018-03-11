package com.example.parkminhyun.wannafootball.data;

/**
 * Created by ParkMinHyun on 2018-03-11.
 */

public class MyTeamVO {

    private int teamID;
    private String teamName;
    private String teamLogoURL;
    private int teamScore;
    private int teamAge;
    private int teamNumber;
    private String teamArea;
    private String teamInfoMessage;

    public MyTeamVO(int teamID, String teamName, String teamLogoURL, int teamScore, int teamAge, int teamNumber, String teamArea, String teamInfoMessage) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.teamLogoURL = teamLogoURL;
        this.teamScore = teamScore;
        this.teamAge = teamAge;
        this.teamNumber = teamNumber;
        this.teamArea = teamArea;
        this.teamInfoMessage = teamInfoMessage;
    }

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
