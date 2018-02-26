package com.example.parkminhyun.wannafootball.screen.fragment.myinfo;

import com.example.parkminhyun.wannafootball.data.UserVO;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public interface MyInfoInterface {

    interface View {
        void initView(UserVO userVO);

        void showLayout(Boolean userLoginStatus);

        void loggedOutView();

        void startLoginActivity();

        void showToast(int text);
    }

    interface Presenter {
        void initPresenter();

        void logoutButtonClick();

        void startLoginActivity();
    }

}
