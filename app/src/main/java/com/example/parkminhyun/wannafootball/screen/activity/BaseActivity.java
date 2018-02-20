package com.example.parkminhyun.wannafootball.screen.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.parkminhyun.wannafootball.common.util.AnimationDirection;
import com.example.parkminhyun.wannafootball.common.util.ScreenAnimationUtils;

import butterknife.ButterKnife;

/**
 * Created by ParkMinHyun on 2018-02-16.
 * onCreate 등 Activity 마다 공통적으로 구현되는 부분의 중복 제거를 위한 BaseActivity.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createPresenter();
        initActivity();
        initEnterAnimation();
    }

    @Override
    public void finish() {
        super.finish();
        initFinishAnimation();
    }

    private void initActivity() {
        setContentView(getLayout());
        ButterKnife.bind(getViews());

        initView();
        initPresenter();
    }

    /**
     * abstract 사용하지 않음으로써 View 초기화가 필요한 Activity만 Override할 수 있음.
     */
    protected AnimationDirection getAnimationDirection() {
        return AnimationDirection.LEFT;
    }

    protected void initEnterAnimation() {
        overridePendingTransition(ScreenAnimationUtils.getEnterAnimationId(getAnimationDirection()),
                                  ScreenAnimationUtils.getFinishAnimationId(getAnimationDirection()));
    }

    protected void initFinishAnimation() {
        overridePendingTransition(ScreenAnimationUtils.getEnterAnimationId(getAnimationDirection()),
                                  ScreenAnimationUtils.getFinishAnimationId(getAnimationDirection()));
    }

    /**
     * StartActivity 관련 Method
     */
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    protected void startActivityClearTop(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void startActivityThenKill(Class<?> cls) {
        startActivityThenKill(cls, null);
    }

    protected void startActivityThenKill(Class<?> cls, Bundle bundle) {
        startActivity(cls, bundle);
        this.finish();
    }

    /**
     * 밑의 Method는 Activity 생성시 꼭 필요하기에 abstract로 구현.
     */
    protected abstract void initView();

    protected abstract void initPresenter();

    protected abstract void createPresenter();

    protected abstract Activity getViews();

    protected abstract int getLayout();

}
