package com.example.parkminhyun.wannafootball.screen.login;

import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class LoginPagePresenter implements LoginPage.Presenter {

    LoginPage.View loginView;
    LoginPageModel loginModel;

    public LoginPagePresenter(LoginPage.View loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginPageModel();
    }

    @Override
    public void loginCheck(MaterialEditText loginEmailText,
                           MaterialEditText loginPasswordText) {

        loginView.startMainActivity();
    }
}
