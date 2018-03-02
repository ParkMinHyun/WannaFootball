package com.example.parkminhyun.wannafootball.data;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class UserVO {

    private String userID;
    private String userName;
    private String userAge;
    private String userPhoneNumber;
    private String userProfileURL;


    public UserVO() {}

    public UserVO(String userID, String userName, String userAge, String userProfileURL) {
        this.userID = userID;
        this.userName = userName;
        this.userAge = userAge;
        this.userProfileURL = userProfileURL;
    }

    public UserVO(String userID, String userName, String userAge,
                  String userPhoneNumber, String userProfileURL) {
        this.userID = userID;
        this.userName = userName;
        this.userAge = userAge;
        this.userPhoneNumber = userPhoneNumber;
        this.userProfileURL = userProfileURL;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserProfileURL() {
        return userProfileURL;
    }

    public void setUserProfileURL(String userProfileURL) {
        this.userProfileURL = userProfileURL;
    }
}
