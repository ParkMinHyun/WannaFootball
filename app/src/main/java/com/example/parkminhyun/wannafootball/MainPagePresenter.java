package com.example.parkminhyun.wannafootball;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class MainPagePresenter implements MainPage.Presenter {

    MainPage.View mainPageView;
    MainPageModel mainPageModel;

    public MainPagePresenter(MainPage.View mainPageView) {
        this.mainPageView = mainPageView;
        this.mainPageModel = new MainPageModel();
    }

    @Override
    public void initUserData() {

    }
}
