package com.example.parkminhyun.wannafootball.db.ro;

import io.realm.RealmObject;

/**
 * Created by ParkMinHyun on 2018-02-27.
 */

public class ScreenSkipRO extends RealmObject{

    private boolean loginScreenSkippedStatus;

    public boolean isLoginPageSkipped() {
        return loginScreenSkippedStatus;
    }

    public void setLoginPageSkipped(boolean loginScreenSkippedStatus) {
        this.loginScreenSkippedStatus = loginScreenSkippedStatus;
    }
}
