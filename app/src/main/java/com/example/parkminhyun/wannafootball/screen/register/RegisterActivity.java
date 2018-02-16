package com.example.parkminhyun.wannafootball.screen.register;

import android.app.Activity;
import android.view.View;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.R;

import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterPage.View {


    RegisterPage.Presenter registerPresenter;

    @OnClick({})
    public void onClick(View view) {
        int id = view.getId();
    }


    @Override
    protected void createPresenter() { registerPresenter = new RegisterPagePresenter(this); }

    @Override
    protected Activity getViews() { return this; }

    @Override
    protected int getLayout() { return R.layout.activity_register; }

}
