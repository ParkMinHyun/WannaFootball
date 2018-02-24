package com.example.parkminhyun.wannafootball.screen.activity.main;

import android.support.v4.app.FragmentManager;

import com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public interface MainPage {

    interface View {
        void updateBottomMenuButton(MainBottomMenu selectedMenu);
    }

    interface Presenter {
        void initFragment();

        void homeButtonClick();
        void searchMatchButtonClick();
        void enrollMatchButtonClick();
        void searchTeamButtonClick();
        void myInfoButtonClick();

        void setSupportFragmentManager(FragmentManager supportFragmentManager);
    }

}
