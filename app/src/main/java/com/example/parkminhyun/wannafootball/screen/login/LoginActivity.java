package com.example.parkminhyun.wannafootball.screen.login;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginPage.View{

    @BindView(R.id.searchPasswordButton)
    TextView searchPasswordButton;

    @BindView(R.id.registerButton)
    TextView registerButton;

    LoginPage.Presenter loginPresenter;

    @OnClick({R.id.searchPasswordButton, R.id.registerButton})
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.searchPasswordButton) {
            loginPresenter.initUserData();
        } else if (id == R.id.registerButton) {
        }
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
