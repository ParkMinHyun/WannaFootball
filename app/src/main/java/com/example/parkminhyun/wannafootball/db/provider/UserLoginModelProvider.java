package com.example.parkminhyun.wannafootball.db.provider;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.example.parkminhyun.wannafootball.db.dao.UserLoginRealmDAO;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserLoginModelProvider {

    private final UserLoginRealmDAO userLoginRealmDAO;


    public static synchronized UserLoginModelProvider getInstance(){
        return Singleton.instance;
    }

    public UserLoginModelProvider(){
        this.userLoginRealmDAO = new UserLoginRealmDAO();
    }

    @NonNull
    @CheckResult
    public Boolean getUserLoginScreenSkipStatus() {
        return userLoginRealmDAO.getUserLoginScreenSkipStatus();
    }

    @NonNull
    @CheckResult
    public Boolean getUserLoggedIn() {
        return userLoginRealmDAO.getUserLoginStatus();
    }

    public void updateUserLogin(String id, Boolean loginStatus) { userLoginRealmDAO.setUserLoginStatus(id, loginStatus);}

    private static class Singleton{
        private static final UserLoginModelProvider instance = new UserLoginModelProvider();
    }
}
