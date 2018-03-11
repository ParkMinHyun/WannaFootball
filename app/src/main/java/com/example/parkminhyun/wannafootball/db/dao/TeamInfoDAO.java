package com.example.parkminhyun.wannafootball.db.dao;

import com.example.parkminhyun.wannafootball.common.base.BaseRealmDAO;
import com.example.parkminhyun.wannafootball.data.MyTeamVO;
import com.example.parkminhyun.wannafootball.db.ro.MyTeamRO;

/**
 * Created by ParkMinHyun on 2018-03-11.
 */

public class TeamInfoDAO extends BaseRealmDAO {

    private MyTeamVO changeTeamROToTeamVO(MyTeamRO myTeamRO) {
        MyTeamVO myTeamVO = new MyTeamVO(
                myTeamRO.getTeamID(),
                myTeamRO.getTeamName(),
                myTeamRO.getTeamLogoURL(),
                myTeamRO.getTeamScore(),
                myTeamRO.getTeamAge(),
                myTeamRO.getTeamNumber(),
                myTeamRO.getTeamArea(),
                myTeamRO.getTeamInfoMessage());
        return myTeamVO;
    }
}
