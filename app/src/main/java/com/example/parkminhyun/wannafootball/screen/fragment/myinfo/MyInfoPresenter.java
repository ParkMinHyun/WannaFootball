package com.example.parkminhyun.wannafootball.screen.fragment.myinfo;

import android.content.Context;
import android.os.Handler;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.login.LoginHelper;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class MyInfoPresenter implements MyInfoInterface.Presenter {

    private MyInfoInterface.View myInfoView;
    private Context context;

    public MyInfoPresenter(MyInfoInterface.View myInfoView) {
        this.myInfoView = myInfoView;
    }

    @Override
    public void initPresenter(Context context) {
        this.context = context;
        initLoginView();
    }

    private void initLoginView() {
        if (LoginHelper.isLoggedIn()) {
            myInfoView.initView(LoginHelper.naverUserInfo(context));
            myInfoView.showLayout(true);
        } else {
            myInfoView.showLayout(false);
        }
    }

    @Override
    public void logoutButtonClick() {
        new Thread(() -> {
            Boolean isSucceeded = LoginHelper.naverLogout(context);
            new Handler().post(() -> {
                if (isSucceeded) {
                    myInfoView.loggedOutView();
                } else {
                    myInfoView.showToast(R.string.logout_fail_message);
                }
            });
        }).start();
    }
}
