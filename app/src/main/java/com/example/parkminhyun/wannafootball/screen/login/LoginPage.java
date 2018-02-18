package com.example.parkminhyun.wannafootball.screen.login;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public interface LoginPage {

    interface View {
        void startMainActivity();

        void startOauthLoginActivity(OAuthLogin mOAuthLoginModule, OAuthLoginHandler mOAuthLoginHandler);

        void setOAuthLoginHandler(OAuthLoginHandler mOAuthLoginHandler);
    }

    interface Presenter {
        void naverLoginButtonClick(LoginActivity loginActivity);

        void nextLoginButtonClick();

        void initNaverLogin(BaseActivity context);
    }

}
