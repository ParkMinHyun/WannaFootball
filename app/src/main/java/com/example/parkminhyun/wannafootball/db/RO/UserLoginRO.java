package com.example.parkminhyun.wannafootball.db.RO;

import io.realm.RealmObject;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserLoginRO extends RealmObject{

    private boolean isLogined;

    public boolean isLogined() {
        return isLogined;
    }

    public void setLogined(boolean logined) {
        isLogined = logined;
    }
}
