package com.example.parkminhyun.wannafootball.db.dao;


import com.example.parkminhyun.wannafootball.db.RO.UserLoginRO;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserLoginRealmDAO extends BaseRealmDAO{

    public Boolean getUserLoginStatus() {

        return query(realm -> {

            UserLoginRO userLoginRO = realm.where(UserLoginRO.class).findFirst();
            if(userLoginRO == null)
                return false;

            else if(userLoginRO.isLogined())
                return true;

            return false;
        });
    }

    public void setUserLoginStatus() {
        modify(realm -> {
            UserLoginRO userLoginRO = realm.where(UserLoginRO.class).findFirst();

            if (userLoginRO == null) {
                userLoginRO = realm.createObject(UserLoginRO.class);
                userLoginRO.setLogined(true);
            }
        });
    }
}
