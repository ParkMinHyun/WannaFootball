package com.example.parkminhyun.wannafootball.screen.activity.login;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.base.BaseActivity;
import com.example.parkminhyun.wannafootball.common.customview.RangeScaleTextView;
import com.example.parkminhyun.wannafootball.screen.activity.main.MainActivity;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginInterface.View {

    @BindView(R.id.naverLoginButton)
    OAuthLoginButton naverLoginButton;

    @BindView(R.id.nextLoginButton)
    RangeScaleTextView nextLoginButton;

    private LoginInterface.Presenter loginPresenter;

    @Override
    protected void initView() {
        getHashKey();
    }

    @Override
    protected void initPresenter() {
        loginPresenter.initUserData();
        loginPresenter.initNaverLogin();
    }

    private void getHashKey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.parkminhyun.wannafootball", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
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
