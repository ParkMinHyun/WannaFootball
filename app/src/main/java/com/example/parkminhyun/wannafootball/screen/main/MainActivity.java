package com.example.parkminhyun.wannafootball.screen.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.parkminhyun.wannafootball.R;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPage.View{

    MainPage.Presenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPagePresenter(this);
        mainPresenter.initUserData();

        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
    }

}
