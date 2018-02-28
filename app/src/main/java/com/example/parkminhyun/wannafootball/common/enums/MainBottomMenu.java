package com.example.parkminhyun.wannafootball.common.enums;

import android.support.annotation.IdRes;

import com.example.parkminhyun.wannafootball.R;

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

    MainBottomMenu(@IdRes int layoutId) {
        this.layoutId = layoutId;
    }

    public int getLayoutId() {
        return layoutId;
    }

}