package com.example.parkminhyun.wannafootball.db.dao;


import com.example.parkminhyun.wannafootball.db.RO.UserLoginRO;

import io.realm.RealmResults;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserLoginRealmDAO extends BaseRealmDAO{

    private static final String USER_LOGIN = "userLogin";

    public Boolean getUserLoginStatus() {

        return query(realm -> {

            RealmResults<UserLoginRO> userLoginRO = realm.where(UserLoginRO.class).findAll();
            if(userLoginRO == null || userLoginRO.get(0).isLogined())
                return false;

            return true;
        });
    }
}
