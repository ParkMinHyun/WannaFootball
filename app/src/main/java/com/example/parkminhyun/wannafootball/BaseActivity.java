package com.example.parkminhyun.wannafootball;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ParkMinHyun on 2018-02-16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createPresenter();
        initView();
    }

    @Override
    public void finish() {
        super.finish();
    }

    private void initView() {
        setContentView(getLayout());
        ButterKnife.bind(getViews());
    }

    protected abstract void createPresenter();

    protected abstract Activity getViews();

    protected abstract int getLayout();

}
