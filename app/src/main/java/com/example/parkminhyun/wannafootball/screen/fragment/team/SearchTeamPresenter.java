package com.example.parkminhyun.wannafootball.screen.fragment.team;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class SearchTeamPresenter implements SearchTeamInterface.Presenter {

    private SearchTeamInterface.View searchTeamView;

    @Override
    public void initPresenter() {

    }

    public SearchTeamPresenter(SearchTeamInterface.View searchTeamView) {
        this.searchTeamView = searchTeamView;
    }
}
