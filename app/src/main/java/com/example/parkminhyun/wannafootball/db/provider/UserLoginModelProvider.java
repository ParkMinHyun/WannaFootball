package com.example.parkminhyun.wannafootball.db.provider;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.example.parkminhyun.wannafootball.db.dao.UserLoginRealmDAO;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserLoginModelProvider {

    private final UserLoginRealmDAO userLoginRealmDAO;

    public UserLoginModelProvider(){
        this.userLoginRealmDAO = new UserLoginRealmDAO();
    }

    @NonNull
    @CheckResult
    public Boolean getUserLogined() {
        return userLoginRealmDAO.getUserLoginStatus();
    }

}
