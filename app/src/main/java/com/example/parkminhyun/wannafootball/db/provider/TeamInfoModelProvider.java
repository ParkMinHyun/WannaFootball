package com.example.parkminhyun.wannafootball.db.provider;

import com.example.parkminhyun.wannafootball.db.dao.TeamInfoDAO;

/**
 * Created by ParkMinHyun on 2018-03-11.
 */

public class TeamInfoModelProvider {

    private TeamInfoDAO teamInfoDAO;

    public TeamInfoModelProvider(){
        this.teamInfoDAO = new TeamInfoDAO();
    }

//    public MyTeamVO getMyTeamInfo() {
//        return teamInfoDAO.getTeamInfo();
//    }
}
