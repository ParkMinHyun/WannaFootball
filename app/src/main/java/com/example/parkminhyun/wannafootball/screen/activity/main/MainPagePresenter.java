package com.example.parkminhyun.wannafootball.screen.activity.main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu;
import com.example.parkminhyun.wannafootball.screen.fragment.home.HomeFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.match.enroll.EnrollMatchingFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.match.search.SearchMatchingFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.myinfo.MyInfoFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.team.SearchTeamFragment;

import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.ENROLL_MATCH;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.HOME;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.MY_INFO;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.SEARCH_MATCH;
import static com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu.SEARCH_TEAM;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class MainPagePresenter implements MainInterface.Presenter {

    private MainInterface.View mainView;
    private FragmentManager fragmentManager;

    public MainPagePresenter(MainInterface.View mainPageView) {
        this.mainView = mainPageView;
    }

    @Override
    public void initFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFragmentContainer, new HomeFragment(), HOME.name());
        fragmentTransaction.commit();
    }

    @Override
    public void homeButtonClick() {
        updateFragment(HOME);
        mainView.updateBottomMenuButton(HOME);
    }

    @Override
    public void searchMatchButtonClick() {
        updateFragment(SEARCH_MATCH);
        mainView.updateBottomMenuButton(SEARCH_MATCH);
    }

    @Override
    public void enrollMatchButtonClick() {
        updateFragment(ENROLL_MATCH);
        mainView.updateBottomMenuButton(ENROLL_MATCH);
    }

    @Override
    public void searchTeamButtonClick() {
        updateFragment(SEARCH_TEAM);
        mainView.updateBottomMenuButton(SEARCH_TEAM);
    }

    @Override
    public void myInfoButtonClick() {
        updateFragment(MY_INFO);
        mainView.updateBottomMenuButton(MY_INFO);
    }

    private void updateFragment(MainBottomMenu selectedMenu) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment replaceFragment = fragmentManager.findFragmentByTag(selectedMenu.name());

        // Fragment 존재할 경우 replace, 존재 안할 경우 add.
        if (replaceFragment != null) {
            fragmentTransaction.replace(R.id.mainFragmentContainer, replaceFragment);
            fragmentTransaction.addToBackStack(null);
        } else {
            Fragment addFragment = searchTagFragment(selectedMenu);
            fragmentTransaction.add(R.id.mainFragmentContainer, addFragment, selectedMenu.name());
        }
        fragmentTransaction.commit();
    }

    private Fragment searchTagFragment(MainBottomMenu selectedMenu) {
        Fragment currentFragment = null;

        switch (selectedMenu){
            case SEARCH_MATCH:
                currentFragment = new SearchMatchingFragment();
                break;
            case ENROLL_MATCH:
                currentFragment = new EnrollMatchingFragment();
                break;
            case SEARCH_TEAM:
                currentFragment = new SearchTeamFragment();
                break;
            case MY_INFO:
                currentFragment = new MyInfoFragment();
                break;
            default:
                currentFragment = new HomeFragment();
                break;
        }

        return currentFragment;
    }

    @Override
    public void setSupportFragmentManager(FragmentManager supportFragmentManager) {
        this.fragmentManager = supportFragmentManager;
    }
}
