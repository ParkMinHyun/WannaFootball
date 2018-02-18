package com.example.parkminhyun.wannafootball.screen.login;

import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public interface LoginPage {

    interface View {
        void startMainActivity();
    }

    interface Presenter {
        void loginCheck(MaterialEditText loginEmailText, MaterialEditText loginPasswordText);
    }

}
