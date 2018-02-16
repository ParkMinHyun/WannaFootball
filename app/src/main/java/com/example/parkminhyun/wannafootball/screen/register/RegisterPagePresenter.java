package com.example.parkminhyun.wannafootball.screen.register;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class RegisterPagePresenter implements RegisterPage.Presenter {

    RegisterPage.View registerView;
    RegisterPageModel registerModel;

    public RegisterPagePresenter(RegisterPage.View registerView) {
        this.registerView = registerView;
        this.registerModel = new RegisterPageModel();
    }

    @Override
    public void initUserData() {
    }
}
