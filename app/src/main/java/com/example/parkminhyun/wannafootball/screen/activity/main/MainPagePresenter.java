package com.example.parkminhyun.wannafootball.screen.activity.main;

import com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu;

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
    public void homeButtonClick() {
        showHomeFragment();
    }

    @Override
    public void searchMatchButtonClick() {
        showSearchMatchingFragment();

    }

    @Override
    public void enrollMatchButtonClick() {
        showEnrollMatchingFragment();

    }

    @Override
    public void searchTeamButtonClick() {
        showSearchTeamFragment();
    }

    @Override
    public void myInfoButtonClick() {
        showMyInfoFragment();
    }

    private void showHomeFragment() {
        mainView.updateBottomMenuButton(MainBottomMenu.HOME);
        mainView.updateFragment(MainBottomMenu.HOME.name());
    }

    private void showSearchMatchingFragment() {
        mainView.updateBottomMenuButton(MainBottomMenu.SEARCH_MATCH);
        mainView.updateFragment(MainBottomMenu.SEARCH_MATCH.name());
    }

    private void showEnrollMatchingFragment() {
        mainView.updateBottomMenuButton(MainBottomMenu.ENROLL_MATCH);
        mainView.updateFragment(MainBottomMenu.ENROLL_MATCH.name());
    }

    private void showSearchTeamFragment() {
        mainView.updateBottomMenuButton(MainBottomMenu.SEARCH_TEAM);
        mainView.updateFragment(MainBottomMenu.SEARCH_TEAM.name());
    }

    private void showMyInfoFragment() {
        mainView.updateBottomMenuButton(MainBottomMenu.MY_INFO);
        mainView.updateFragment(MainBottomMenu.MY_INFO.name());
    }
}
