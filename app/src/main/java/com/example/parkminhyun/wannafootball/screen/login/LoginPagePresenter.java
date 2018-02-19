package com.example.parkminhyun.wannafootball.screen.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.db.provider.UserLoginModelProvider;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.parkminhyun.wannafootball.common.constant.UserConstant.NOT_INPUTED_USER_ID;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class LoginPagePresenter implements LoginPage.Presenter {

    private LoginPage.View loginView;

    private final String CLIENT_ID = "ajkQnVpM4y94tf3XjIlw";
    private final String CLIENT_SECRET = "TyVWYW36Mr";
    private final String CLIENT_NAME = "DoYouWantToSoccer?";
    private final String USER_URL = "https://openapi.naver.com/v1/nid/me";

    private Context context;
    public OAuthLogin mOAuthLoginModule;

    private UserLoginModelProvider userLoginModelProvider;

    public LoginPagePresenter(LoginPage.View loginView) {
        this.loginView = loginView;
        this.userLoginModelProvider = new UserLoginModelProvider();
    }

    @Override
    public void initNaverLogin(BaseActivity context) {
        // 이미 로그인 되어 있거나, 다음에 보기 클릭했을 경우 Skip 하기
        // TODO : 나중에 Splash 만들면 Splash 화면에서 분기처리 해주기
        if (userLoginModelProvider.getUserLogined())
            startMainActivity();
        else {
            this.context = context;
            mOAuthLoginModule = OAuthLogin.getInstance();
            mOAuthLoginModule.init(context, CLIENT_ID, CLIENT_SECRET, CLIENT_NAME);
            loginView.setOAuthLoginHandler(mOAuthLoginHandler);
        }
    }

    @SuppressLint("HandlerLeak")
    private OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                String accessToken = mOAuthLoginModule.getAccessToken(context);
                setUserInfo(accessToken);

            } else {
                String errorCode = mOAuthLoginModule.getLastErrorCode(context).getCode();
                String errorDesc = mOAuthLoginModule.getLastErrorDesc(context);
                Toast.makeText(context, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void setUserInfo(String accessToken) {
        new Thread(() -> {
            String response = mOAuthLoginModule.requestApi(context, accessToken, USER_URL);
            try {
                JSONObject jsonObject = new JSONObject(response);
                String userID = jsonObject.getJSONObject("response").getString("id");
                userLoginModelProvider.updateUserLogin(userID);
                startMainActivity();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void startMainActivity() {
        loginView.startMainActivity();
    }

    @Override
    public void naverLoginButtonClick() {
        loginView.startOauthLoginActivity(mOAuthLoginModule, mOAuthLoginHandler);
    }

    @Override
    public void nextLoginButtonClick() {
        userLoginModelProvider.updateUserLogin(NOT_INPUTED_USER_ID);
        startMainActivity();
    }

}
