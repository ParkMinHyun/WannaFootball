package com.example.parkminhyun.wannafootball.screen.fragment.myinfo;

import android.content.Context;
import android.widget.Toast;

import com.example.parkminhyun.wannafootball.MainApplication;
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
        LoginHelper.initNaverAuthInstance(context);
        myInfoView.showLayout(LoginHelper.isLoggedIn());
    }

    @Override
    public void logoutButtonClick() {
        new Thread(() -> {
            if (LoginHelper.naverLogout(context))
                myInfoView.startLoginActivity();
            else
                Toast.makeText(MainApplication.getInstance(),"로그아웃에 실패했습니다.",Toast.LENGTH_SHORT).show();
        }).start();
    }

}
