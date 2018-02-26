package com.example.parkminhyun.wannafootball.db.provider;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.example.parkminhyun.wannafootball.db.dao.ScreenSkipRealmDAO;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class ScreenSkipModelProvider {

    private final ScreenSkipRealmDAO screenSkipRealmDAO;

    public ScreenSkipModelProvider() {
        this.screenSkipRealmDAO = new ScreenSkipRealmDAO();
    }

    @NonNull
    @CheckResult
    public Boolean getLoginScreenSkipStatus() {
        return screenSkipRealmDAO.getLoginScreenSkipStatus();
    }

    public void updateLoginScreenSkipStatus(Boolean loginScreenSkipStatus) {
        screenSkipRealmDAO.setLoginScreenSkipStatus(loginScreenSkipStatus);
    }
}
