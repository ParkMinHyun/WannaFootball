package com.example.parkminhyun.wannafootball.screen.fragment.home;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class HomePresenter implements HomeInterface.Presenter {

    private HomeInterface.View homeView;

    public HomePresenter(HomeInterface.View homeView) {
        this.homeView = homeView;
    }

}
