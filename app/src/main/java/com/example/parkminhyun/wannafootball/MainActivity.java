package com.example.parkminhyun.wannafootball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainPage.View{

    MainPage.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPagePresenter(this);
        presenter.initUserData();

        initView();
    }

    private void initView() {

    }
}
