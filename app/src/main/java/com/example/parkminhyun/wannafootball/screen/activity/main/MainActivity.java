package com.example.parkminhyun.wannafootball.screen.activity.main;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.enums.MainBottomMenu;
import com.example.parkminhyun.wannafootball.common.util.EventClickManager;
import com.example.parkminhyun.wannafootball.common.base.BaseActivity;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainPage.View {

    @BindViews({
            R.id.home_button,
            R.id.home_search_match_button,
            R.id.home_enroll_match_button,
            R.id.home_search_team_button,
            R.id.home_my_info_button})
    TextView[] mainBottomMenuTextViews;

    @BindView(R.id.mainFragmentContainer)
    View mainFragmentContainer;

    private MainPage.Presenter mainPresenter;

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void initView() {
    }

    @Override
    protected void initPresenter() {
        mainPresenter.setSupportFragmentManager(getSupportFragmentManager());
        mainPresenter.initFragment();
    }

    @OnClick({R.id.layout_home, R.id.layout_search_match, R.id.layout_enroll_match, R.id.layout_search_team, R.id.layout_my_info})
    void onClick(View view) {
        if (!EventClickManager.isClickable(view)) {
            return;
        }

        switch (view.getId()) {
            case R.id.layout_home:
                mainPresenter.homeButtonClick();
                break;
            case R.id.layout_search_match:
                mainPresenter.searchMatchButtonClick();
                break;
            case R.id.layout_enroll_match:
                mainPresenter.enrollMatchButtonClick();
                break;
            case R.id.layout_search_team:
                mainPresenter.searchTeamButtonClick();
                break;
            case R.id.layout_my_info:
                mainPresenter.myInfoButtonClick();
                break;
            default:
                break;
        }
    }

    @Override
    public void updateBottomMenuButton(MainBottomMenu selectedMenu) {
        for (TextView view : mainBottomMenuTextViews) {
            boolean isSelected = view.getId() == selectedMenu.getLayoutId();
            view.setSelected(isSelected);
        }
    }

    @Override
    public void finish() {
        super.finish();
        this.finishAffinity();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.double_exit_button_click), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
    }

    @Override
    protected void createPresenter() {
        mainPresenter = new MainPagePresenter(this);
    }

    @Override
    protected Activity getViews() {
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
