package com.example.parkminhyun.wannafootball.db.dao;


import com.example.parkminhyun.wannafootball.common.base.BaseRealmDAO;
import com.example.parkminhyun.wannafootball.db.ro.ScreenSkipRO;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class ScreenSkipRealmDAO extends BaseRealmDAO {

    public Boolean getLoginScreenSkipStatus() {

        return query(realm -> {

            ScreenSkipRO screenSkipRO = realm.where(ScreenSkipRO.class).findFirst();
            if (screenSkipRO == null)
                return false;

            return screenSkipRO.isLoginPageSkipped();
        });
    }

    public void setLoginScreenSkipStatus(Boolean loginScreenSkipStatus) {
        modify(realm -> {
            ScreenSkipRO screenSkipRO = realm.where(ScreenSkipRO.class).findFirst();

            if (screenSkipRO == null) {
                screenSkipRO = realm.createObject(ScreenSkipRO.class);
            }
            screenSkipRO.setLoginPageSkipped(loginScreenSkipStatus);
        });
    }

}
