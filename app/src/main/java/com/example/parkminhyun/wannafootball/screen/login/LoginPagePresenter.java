package com.example.parkminhyun.wannafootball.screen.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class LoginPagePresenter implements LoginPage.Presenter {

    private LoginPage.View loginView;

    private final String CLIENT_ID = "ajkQnVpM4y94tf3XjIlw";
    private final String CLIENT_SECRET = "TyVWYW36Mr";
    private final String CLIENT_NAME = "DoYouWantToSoccer?";

    private Context context;
    public OAuthLogin mOAuthLoginModule;

    public LoginPagePresenter(LoginPage.View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void initNaverLogin(BaseActivity context) {
        this.context = context;
        mOAuthLoginModule = OAuthLogin.getInstance();
        mOAuthLoginModule.init(context, CLIENT_ID, CLIENT_SECRET, CLIENT_NAME);
        loginView.setOAuthLoginHandler(mOAuthLoginHandler);
    }

    @SuppressLint("HandlerLeak")
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginModule.getAccessToken(context);
                String refreshToken = mOAuthLoginModule.getRefreshToken(context);
                long expiresAt = mOAuthLoginModule.getExpiresAt(context);
                String tokenType = mOAuthLoginModule.getTokenType(context);
            } else {
                String errorCode = mOAuthLoginModule.getLastErrorCode(context).getCode();
                String errorDesc = mOAuthLoginModule.getLastErrorDesc(context);
                Toast.makeText(context, "errorCode:" + errorCode
                        + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }
    };


    @Override
    public void naverLoginButtonClick(LoginActivity loginActivity) {
        loginView.startOauthLoginActivity(mOAuthLoginModule, mOAuthLoginHandler);
    }

    @Override
    public void nextLoginButtonClick() {
    }

}
