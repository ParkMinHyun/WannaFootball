package com.example.parkminhyun.wannafootball.screen.main;

import android.app.Activity;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.R;

public class MainActivity extends BaseActivity implements MainPage.View{

    MainPage.Presenter mainPresenter;

    @Override
    protected void init(BaseActivity context) {

    }

    @Override
    protected void createPresenter() { mainPresenter = new MainPagePresenter(this); }

    @Override
    protected Activity getViews() { return this; }

    @Override
    protected int getLayout() { return R.layout.activity_main; }

}
