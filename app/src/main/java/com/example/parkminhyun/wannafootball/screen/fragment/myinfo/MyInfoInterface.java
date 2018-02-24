package com.example.parkminhyun.wannafootball.screen.fragment.myinfo;

import android.content.Context;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public interface MyInfoInterface {

    interface View {
        void showLayout(Boolean userLoginStatus);

        void startLoginActivity();
    }

    interface Presenter {
        void initPresenter(Context context);

        void logoutButtonClick();
    }

}
