package com.example.parkminhyun.wannafootball.db.ro;

import io.realm.RealmObject;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserLoginRO extends RealmObject{

    private boolean isLogined;
    private String userID;

    public boolean isLogined() {
        return isLogined;
    }

    public void setLogined(boolean logined) {
        isLogined = logined;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
