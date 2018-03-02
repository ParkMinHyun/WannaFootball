package com.example.parkminhyun.wannafootball.db.ro;

import com.example.parkminhyun.wannafootball.data.UserVO;

import io.realm.RealmObject;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserRO extends RealmObject{

    private boolean isLoggedIn;

    private String userID;
    private String userName;
    private String userAge;
    private String userPhoneNumber;
    private String userProfileURL;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
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

    public void setUserVO(UserVO userVO) {
        setUserID(userVO.getUserID());
        setUserName(userVO.getUserName());
        setUserAge(userVO.getUserAge());
        setUserPhoneNumber(userVO.getUserPhoneNumber());
        setUserProfileURL(userVO.getUserProfileURL());
    }
}
