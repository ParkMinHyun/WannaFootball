package com.example.parkminhyun.wannafootball.db.provider;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.example.parkminhyun.wannafootball.data.UserVO;
import com.example.parkminhyun.wannafootball.db.dao.UserRealmDAO;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserLoginModelProvider {

    private final UserRealmDAO userLoginRealmDAO;

    public static synchronized UserLoginModelProvider getInstance() {
        return Singleton.instance;
    }

    public UserLoginModelProvider() {
        this.userLoginRealmDAO = new UserRealmDAO();
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

    public UserVO getUserVO() {
        return userLoginRealmDAO.getUserVOInUserRO();
    }

    public void updateUserLogin(String id, Boolean loginStatus) {
        userLoginRealmDAO.setUserLoginStatus(id, loginStatus);
    }

    public void updateUserVO(UserVO userVO) {
        userLoginRealmDAO.setUserVO(userVO);
    }

    private static class Singleton {
        private static final UserLoginModelProvider instance = new UserLoginModelProvider();
    }
}
