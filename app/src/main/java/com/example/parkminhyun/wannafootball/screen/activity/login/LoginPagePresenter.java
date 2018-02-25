package com.example.parkminhyun.wannafootball.screen.activity.login;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.parkminhyun.wannafootball.common.base.BaseActivity;
import com.example.parkminhyun.wannafootball.common.login.LoginHelper;
import com.nhn.android.naverlogin.OAuthLoginHandler;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.parkminhyun.wannafootball.common.constant.UserConstant.NOT_INPUTTED_USER_ID;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class LoginPagePresenter implements LoginInterface.Presenter {

    private LoginInterface.View loginView;
    private Context context;

    public LoginPagePresenter(LoginInterface.View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void initNaverLogin(BaseActivity context) {
        // 이미 로그인 되어 있거나, 다음에 보기 클릭했을 경우 Skip 하기
        // TODO : 나중에 Splash 만들면 Splash 화면에서 분기처리 해주기
        if (LoginHelper.isLoginScreenSkipped())
            startMainActivity();
        else {
            this.context = context;
            LoginHelper.initNaverAuthInstance(context);
            loginView.setOAuthLoginHandler(mOAuthLoginHandler);
        }
    }

    @SuppressLint("HandlerLeak")
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = LoginHelper.getAccessToken(context);
                setUserInfo(accessToken);
            }
        }
    };

    private void setUserInfo(String accessToken) {
        new Thread(() -> {
            String response = LoginHelper.naverRequestApi(context, accessToken);
            try {
                JSONObject jsonObject = new JSONObject(response);
                String userID = jsonObject.getJSONObject("response").getString("id");
                LoginHelper.updateUserLogin(userID, true);
                startMainActivity();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void startMainActivity() {
        loginView.startMainActivity();
    }

    @Override
    public void naverLoginButtonClick() {
        loginView.startOauthLoginActivity(LoginHelper.getOAuthLoginModule(), mOAuthLoginHandler);
    }

    @Override
    public void nextLoginButtonClick() {
        LoginHelper.updateUserLogin(NOT_INPUTTED_USER_ID, true);
        startMainActivity();
    }

}
