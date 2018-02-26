package com.example.parkminhyun.wannafootball.screen.activity.login;

import android.app.Activity;
import android.view.View;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.customview.RangeScaleTextView;
import com.example.parkminhyun.wannafootball.common.base.BaseActivity;
import com.example.parkminhyun.wannafootball.screen.activity.main.MainActivity;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginInterface.View {

    @BindView(R.id.naverLoginButton)
    OAuthLoginButton naverLoginButton;

    @BindView(R.id.nextLoginButton)
    RangeScaleTextView nextLoginButton;

    private LoginInterface.Presenter loginPresenter;

    @Override
    protected void initView() {}

    @Override
    protected void initPresenter() {
        loginPresenter.initUserData();
        loginPresenter.initNaverLogin();
    }

    @OnClick({R.id.naverLoginButton, R.id.nextLoginButton})
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.naverLoginButton) {
            loginPresenter.naverLoginButtonClick();
        } else if (id == R.id.nextLoginButton) {
            loginPresenter.nextLoginButtonClick();
        }
    }

    @Override
    public void setOAuthLoginHandler(OAuthLoginHandler mOAuthLoginHandler) {
        naverLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);
    }

    @Override
    public void startMainActivity() {
        startActivityClearTop(MainActivity.class);
    }

    @Override
    public void startOauthLoginActivity(OAuthLogin mOAuthLoginModule, OAuthLoginHandler mOAuthLoginHandler) {
        mOAuthLoginModule.startOauthLoginActivity(LoginActivity.this, mOAuthLoginHandler);
    }

    @Override
    protected void createPresenter() {
        loginPresenter = new LoginPagePresenter(this);
    }

    @Override
    protected Activity getViews() {
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }
}
