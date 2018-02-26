package com.example.parkminhyun.wannafootball.screen.fragment.myinfo;

import android.os.Handler;

import com.example.parkminhyun.wannafootball.App;
import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.login.LoginHelper;
import com.example.parkminhyun.wannafootball.data.UserVO;
import com.example.parkminhyun.wannafootball.db.provider.UserLoginModelProvider;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class MyInfoPresenter implements MyInfoInterface.Presenter {

    private MyInfoInterface.View myInfoView;
    private UserLoginModelProvider userLoginModelProvider;

    public MyInfoPresenter(MyInfoInterface.View myInfoView) {
        this.myInfoView = myInfoView;
    }

    @Override
    public void initPresenter() {
        initUserData();
        initLoginView();
    }

    private void initUserData() {
        userLoginModelProvider = UserLoginModelProvider.getInstance();
    }

    private void initLoginView() {
        if (LoginHelper.isLoggedIn()) {
            UserVO userVO = userLoginModelProvider.getUserVO();
            myInfoView.initView(userVO);
            myInfoView.showLayout(true);
        } else {
            myInfoView.showLayout(false);
        }
    }

    @Override
    public void logoutButtonClick() {
        Handler handler = new Handler();
        new Thread(() -> {
            Boolean isSucceeded = LoginHelper.naverLogout(App.getInstance());
            handler.post(() -> {
                if (isSucceeded) {
                    myInfoView.loggedOutView();
                } else {
                    myInfoView.showToast(R.string.logout_fail_message);
                }
            });
        }).start();
    }
}
