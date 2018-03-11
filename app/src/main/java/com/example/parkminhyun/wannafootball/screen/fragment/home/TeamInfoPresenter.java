package com.example.parkminhyun.wannafootball.screen.fragment.home;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class TeamInfoPresenter implements TeamInfoInterface.Presenter {

    private TeamInfoInterface.View homeView;

    public TeamInfoPresenter(TeamInfoInterface.View homeView) {
        this.homeView = homeView;
    }

}
