package com.example.parkminhyun.wannafootball.screen.activity.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.screen.fragment.HomeFragment;

import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.ENROLL_MATCH;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.HOME;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.MY_INFO;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.SEARCH_MATCH;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.SEARCH_TEAM;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.getFragment;

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
        fragmentTransaction.add(R.id.mainFragmentContainer, new HomeFragment(), HOME.name());
        fragmentTransaction.commit();
    }

    @Override
    public void homeButtonClick() {
        updateFragment(HOME.name());
        mainView.updateBottomMenuButton(HOME);
    }

    @Override
    public void searchMatchButtonClick() {
        updateFragment(SEARCH_MATCH.name());
        mainView.updateBottomMenuButton(SEARCH_MATCH);
    }

    @Override
    public void enrollMatchButtonClick() {
        updateFragment(ENROLL_MATCH.name());
        mainView.updateBottomMenuButton(ENROLL_MATCH);
    }

    @Override
    public void searchTeamButtonClick() {
        updateFragment(SEARCH_TEAM.name());
        mainView.updateBottomMenuButton(SEARCH_TEAM);
    }

    @Override
    public void myInfoButtonClick() {
        updateFragment(MY_INFO.name());
        mainView.updateBottomMenuButton(MY_INFO);
    }

    private void updateFragment(String selectedFragmentName) {
        fragment = getFragment(selectedFragmentName);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFragmentContainer, fragment, selectedFragmentName);
        fragmentTransaction.commit();
    }

    @Override
    public void setSupportFragmentManager(FragmentManager supportFragmentManager) {
        this.fragmentManager = supportFragmentManager;
    }
}
