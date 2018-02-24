package com.example.parkminhyun.wannafootball.db.dao;


import com.example.parkminhyun.wannafootball.db.ro.UserLoginRO;

import static com.example.parkminhyun.wannafootball.common.constant.UserConstant.NOT_INPUTTED_USER_ID;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserLoginRealmDAO extends BaseRealmDAO{

    public Boolean getUserLoginScreenSkipStatus() {

        return query(realm -> {

            UserLoginRO userLoginRO = realm.where(UserLoginRO.class).findFirst();
            if(userLoginRO == null)
                return false;

            else if(userLoginRO.isLogined())
                return true;

            return false;
        });
    }

    public Boolean getUserLoginStatus() {

        return query(realm -> {

            UserLoginRO userLoginRO = realm.where(UserLoginRO.class).findFirst();
            if(userLoginRO == null)
                return false;

            else if(userLoginRO.getUserID().equals(NOT_INPUTTED_USER_ID))
                return false;

            return true;
        });
    }

    public void setUserLoginStatus(String id, Boolean loginStatus) {
        modify(realm -> {
            UserLoginRO userLoginRO = realm.where(UserLoginRO.class).findFirst();

            if (userLoginRO == null) {
                userLoginRO = realm.createObject(UserLoginRO.class);
            }
            userLoginRO.setLogined(loginStatus);
            userLoginRO.setUserID(id);
        });
    }
}
