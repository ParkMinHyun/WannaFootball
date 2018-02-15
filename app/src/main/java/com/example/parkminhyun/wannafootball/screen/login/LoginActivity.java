package com.example.parkminhyun.wannafootball.screen.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.screen.main.MainPage;
import com.example.parkminhyun.wannafootball.screen.main.MainPagePresenter;

public class LoginActivity extends AppCompatActivity implements LoginPage.View{

    LoginPage.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPagePresenter(this);
        loginPresenter.initUserData();

        initView();
    }

    private void initView() {
    }

}
