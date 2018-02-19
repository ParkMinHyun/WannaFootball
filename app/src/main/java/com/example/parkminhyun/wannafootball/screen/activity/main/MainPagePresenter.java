package com.example.parkminhyun.wannafootball.screen.activity.main;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class MainPagePresenter implements MainPage.Presenter {

    MainPage.View mainView;
    MainPageModel mainModel;

    public MainPagePresenter(MainPage.View mainPageView) {
        this.mainView = mainPageView;
        this.mainModel = new MainPageModel();
    }

    @Override
    public void initUserData() {

    }
}
