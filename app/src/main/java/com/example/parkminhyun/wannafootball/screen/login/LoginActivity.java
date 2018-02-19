package com.example.parkminhyun.wannafootball.screen.login;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.customview.RangeScaleTextView;
import com.example.parkminhyun.wannafootball.screen.main.MainActivity;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginPage.View {

    @BindView(R.id.naverLoginButton)
    OAuthLoginButton naverLoginButton;

    @BindView(R.id.nextLoginButton)
    RangeScaleTextView nextLoginButton;

    private LoginPage.Presenter loginPresenter;

    @Override
    protected void init(BaseActivity context) {
        loginPresenter.initNaverLogin(context);
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
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
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
