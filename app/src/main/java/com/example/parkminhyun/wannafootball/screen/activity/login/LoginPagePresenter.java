package com.example.parkminhyun.wannafootball.screen.activity.login;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.example.parkminhyun.wannafootball.App;
import com.example.parkminhyun.wannafootball.common.login.LoginHelper;
import com.example.parkminhyun.wannafootball.common.login.NaverRequestAPITask;
import com.example.parkminhyun.wannafootball.data.UserVO;
import com.example.parkminhyun.wannafootball.db.provider.UserLoginModelProvider;
import com.nhn.android.naverlogin.OAuthLoginHandler;

import java.util.concurrent.ExecutionException;

import static com.example.parkminhyun.wannafootball.common.constant.UserConstant.NOT_INPUTTED_USER_ID;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class LoginPagePresenter implements LoginInterface.Presenter {

    private LoginInterface.View loginView;
    private UserLoginModelProvider userLoginModelProvider;

    public LoginPagePresenter(LoginInterface.View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void initUserData() {
        userLoginModelProvider = UserLoginModelProvider.getInstance();
    }

    @Override
    public void initNaverLogin() {
        // 이미 로그인 되어 있거나, 다음에 보기 클릭했을 경우 Skip 하기
        // TODO : 나중에 Splash 만들면 Splash 화면에서 분기처리 해주기
        if (LoginHelper.isLoginScreenSkipStatus()) {
            loginView.startMainActivity();
        } else {
            loginView.setOAuthLoginHandler(mOAuthLoginHandler);
        }
    }

    @SuppressLint("HandlerLeak")
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = LoginHelper.getAccessToken(App.getInstance());

                // 로그인 정보가 있다면 유저 정보 갱신 실행 X
                if(!userLoginModelProvider.getUserLoggedIn()) {
                    setUserInfo(accessToken);
                }
            }
        }
    };

    private void setUserInfo(String accessToken) {
        new Thread(() -> {
            try {
                NaverRequestAPITask naverRequestAPITask = new NaverRequestAPITask(accessToken);
                UserVO myInfoVO = naverRequestAPITask.execute().get();

                userLoginModelProvider.updateUserVO(myInfoVO);
                // AsyncTask 종료시켜 주기
                if (naverRequestAPITask.getStatus() == AsyncTask.Status.RUNNING) {
                    naverRequestAPITask.cancel(true);
                }

                LoginHelper.updateUserLogin(myInfoVO.getUserID(),true);
                LoginHelper.updatedLoggedInScreenSkip(true);
                loginView.startMainActivity();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void naverLoginButtonClick() {
        loginView.startOauthLoginActivity(LoginHelper.getOAuthLoginModule(), mOAuthLoginHandler);
    }

    @Override
    public void nextLoginButtonClick() {
        LoginHelper.updatedLoggedInScreenSkip(true);
        LoginHelper.updateUserLogin(NOT_INPUTTED_USER_ID, false);
        loginView.startMainActivity();
    }
}
