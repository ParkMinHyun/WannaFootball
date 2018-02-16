package com.example.parkminhyun.wannafootball;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ParkMinHyun on 2018-02-16.
 * onCreate 등 Activity 마다 공통적으로 구현되는 부분의 중복 제거를 위한 BaseActivity.
 * TODO: 화면 올라오는 Animation 구현.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createPresenter();
        initActivity();
    }

    @Override
    public void finish() {
        super.finish();
    }

    private void initActivity() {
        setContentView(getLayout());
        ButterKnife.bind(getViews());

        initView(this);
    }

    /**
     * abstract 사용하지 않음으로써 View 초기화가 필요한 Activity만 Override할 수 있음.
     */
    protected void initView(BaseActivity context){}

    /**
     * 밑 3개 Method는 Activity 생성시 꼭 필요하기에 abstract로 구현.
     */
    protected abstract void createPresenter();

    protected abstract Activity getViews();

    protected abstract int getLayout();

}
