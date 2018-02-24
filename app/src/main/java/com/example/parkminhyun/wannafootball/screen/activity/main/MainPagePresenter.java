package com.example.parkminhyun.wannafootball.screen.activity.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu;
import com.example.parkminhyun.wannafootball.screen.fragment.HomeFragment;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class MainPagePresenter implements MainPage.Presenter {

    private MainPage.View mainView;
    private MainPageModel mainModel;

    private FragmentManager fragmentManager;
    private Fragment fragment;

    public MainPagePresenter(MainPage.View mainPageView) {
        this.mainView = mainPageView;
        this.mainModel = new MainPageModel();
    }

    @Override
    public void initFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFragmentContainer, new HomeFragment(), MainBottomMenu.HOME.name());
        fragmentTransaction.commit();
    }

    @Override
    public void homeButtonClick() {
        updateFragment(MainBottomMenu.HOME.name());
        mainView.updateBottomMenuButton(MainBottomMenu.HOME);
    }

    @Override
    public void searchMatchButtonClick() {
        updateFragment(MainBottomMenu.SEARCH_MATCH.name());
        mainView.updateBottomMenuButton(MainBottomMenu.SEARCH_MATCH);
    }

    @Override
    public void enrollMatchButtonClick() {
        updateFragment(MainBottomMenu.ENROLL_MATCH.name());
        mainView.updateBottomMenuButton(MainBottomMenu.ENROLL_MATCH);
    }

    @Override
    public void searchTeamButtonClick() {
        updateFragment(MainBottomMenu.SEARCH_TEAM.name());
        mainView.updateBottomMenuButton(MainBottomMenu.SEARCH_TEAM);
    }

    @Override
    public void myInfoButtonClick() {
        updateFragment(MainBottomMenu.MY_INFO.name());
        mainView.updateBottomMenuButton(MainBottomMenu.MY_INFO);
    }

    private void updateFragment(String selectedFragmentName) {
        fragment = MainBottomMenu.getFragment(selectedFragmentName);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFragmentContainer, fragment, selectedFragmentName);
        fragmentTransaction.commit();
    }

    @Override
    public void setSupportFragmentManager(FragmentManager supportFragmentManager) {
        this.fragmentManager = supportFragmentManager;
    }
}
