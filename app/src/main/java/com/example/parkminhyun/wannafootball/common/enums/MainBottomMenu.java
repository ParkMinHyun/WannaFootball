package com.example.parkminhyun.wannafootball.common.enums;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.screen.fragment.match.enroll.EnrollMatchingFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.home.HomeFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.myinfo.MyInfoFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.match.search.SearchMatchingFragment;
import com.example.parkminhyun.wannafootball.screen.fragment.team.SearchTeamFragment;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public enum MainBottomMenu {

    HOME(R.id.home_button),
    SEARCH_MATCH(R.id.home_search_match_button),
    ENROLL_MATCH(R.id.home_enroll_match_button),
    SEARCH_TEAM(R.id.home_search_team_button),
    MY_INFO(R.id.home_my_info_button);

    private int layoutId;
    private static Fragment currentFragment = new HomeFragment();

    MainBottomMenu(@IdRes int layoutId) {
        this.layoutId = layoutId;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public static Fragment getFragment(String selectedMenuName) {

        if (selectedMenuName.equals(SEARCH_MATCH.name())) {
            currentFragment = new SearchMatchingFragment();
        } else if (selectedMenuName.equals(ENROLL_MATCH.name())) {
            currentFragment = new EnrollMatchingFragment();
        } else if (selectedMenuName.equals(SEARCH_TEAM.name())) {
            currentFragment = new SearchTeamFragment();
        } else if (selectedMenuName.equals(MY_INFO.name())) {
            currentFragment = new MyInfoFragment();
        } else {
            currentFragment = new HomeFragment();
        }
        return currentFragment;
    }
}