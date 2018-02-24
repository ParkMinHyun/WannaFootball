package com.example.parkminhyun.wannafootball.screen.activity.main;

import com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public interface MainPage {

    interface View {
        void updateBottomMenuButton(MainBottomMenu selectedMenu);

        void updateFragment(String name);
    }

    interface Presenter {
        void homeButtonClick();
        void searchMatchButtonClick();
        void enrollMatchButtonClick();
        void searchTeamButtonClick();
        void myInfoButtonClick();
    }

}
