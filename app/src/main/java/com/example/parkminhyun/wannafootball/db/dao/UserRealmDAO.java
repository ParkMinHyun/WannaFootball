package com.example.parkminhyun.wannafootball.db.dao;


import com.example.parkminhyun.wannafootball.data.UserVO;
import com.example.parkminhyun.wannafootball.db.ro.UserRO;

import static com.example.parkminhyun.wannafootball.common.constant.UserConstant.NOT_INPUTTED_USER_ID;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class UserRealmDAO extends BaseRealmDAO {

    public Boolean getUserLoginStatus() {

        return query(realm -> {

            UserRO userLoginRO = realm.where(UserRO.class).findFirst();
            if (userLoginRO == null)
                return false;

            else if (userLoginRO.getUserID().equals(NOT_INPUTTED_USER_ID))
                return false;

            return true;
        });
    }

    public UserVO getUserVOInUserRO() {
        return query(realm -> {

            UserRO userRO = realm.where(UserRO.class).findFirst();
            if (userRO == null)
                return null;

            return changeUserROToUserVO(userRO);
        });
    }

    private UserVO changeUserROToUserVO(UserRO userRO) {
        UserVO userVO = new UserVO(
                userRO.getUserID(),
                userRO.getUserName(),
                userRO.getUserAge(),
                userRO.getUserProfileURL());
        return userVO;
    }

    public void setUserLoginStatus(String id, Boolean loginStatus) {
        modify(realm -> {
            UserRO userLoginRO = realm.where(UserRO.class).findFirst();

            if (userLoginRO == null) {
                userLoginRO = realm.createObject(UserRO.class);
            }
            userLoginRO.setLoggedIn(loginStatus);
            userLoginRO.setUserID(id);
        });
    }

    public void setUserVO(UserVO userVO) {
        modify(realm -> {
            UserRO userLoginRO = realm.where(UserRO.class).findFirst();

            if (userLoginRO == null) {
                userLoginRO = realm.createObject(UserRO.class);
            }
            userLoginRO.setUserVO(userVO);
        });
    }

}
