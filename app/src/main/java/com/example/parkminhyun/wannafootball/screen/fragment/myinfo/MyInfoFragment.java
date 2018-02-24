package com.example.parkminhyun.wannafootball.screen.fragment.myinfo;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.base.BaseFragment;
import com.example.parkminhyun.wannafootball.common.util.EventClickManager;
import com.example.parkminhyun.wannafootball.screen.activity.login.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class MyInfoFragment extends BaseFragment implements MyInfoInterface.View {

    @BindView(R.id.userLoginLayout)
    View userLoginLayout;

    @BindView(R.id.userNotLoginLayout)
    View userNotLoginLayout;

    @BindView(R.id.reviseMyInfoButton)
    TextView reviseMyInfoButton;

    @BindView(R.id.myPhotoView)
    ImageView myPhotoView;

    @BindView(R.id.myNameView)
    TextView myNameView;

    @BindView(R.id.myAgeView)
    TextView myAgeView;

    @BindView(R.id.myTeamNameView)
    TextView myTeamNameView;

    @BindView(R.id.logoutButton)
    ImageView logoutButton;

    @BindView(R.id.moveLoginPageButton)
    Button moveLoginPageButton;

    private MyInfoPresenter myInfoPresenter;

    @Override
    protected void initView() {
        myInfoPresenter.initPresenter(getActivity());
    }

    @OnClick({R.id.reviseMyInfoButton, R.id.myPhotoView, R.id.myNameView,
            R.id.myAgeView, R.id.myTeamNameView, R.id.logoutButton, R.id.moveLoginPageButton})
    void onClick(View view) {
        if (!EventClickManager.isClickable(view)) {
            return;
        }

        switch (view.getId()) {
            case R.id.reviseMyInfoButton:
//                myInfoPresenter.homeButtonClick();
                break;
            case R.id.myPhotoView:
//                myInfoPresenter.searchMatchButtonClick();
                break;
            case R.id.myNameView:
//                myInfoPresenter.enrollMatchButtonClick();
                break;
            case R.id.myAgeView:
//                myInfoPresenter.searchTeamButtonClick();
                break;
            case R.id.myTeamNameView:
//                myInfoPresenter.myInfoButtonClick();
                break;
            case R.id.logoutButton:
                myInfoPresenter.logoutButtonClick();
                break;
            case R.id.moveLoginPageButton:
//                myInfoPresenter.myInfoButtonClick();
                break;
            default:
                break;
        }
    }

    @Override
    public void showLayout(Boolean userLoginStatus) {
        if (userLoginStatus) {
            userLoginLayout.setVisibility(View.VISIBLE);
            userNotLoginLayout.setVisibility(View.GONE);
        } else {
            userLoginLayout.setVisibility(View.GONE);
            userNotLoginLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void startLoginActivity() {
        startActivityClearTop(LoginActivity.class);
    }

    @Override
    protected void createPresenter() {
        myInfoPresenter = new MyInfoPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_my_info;
    }

}