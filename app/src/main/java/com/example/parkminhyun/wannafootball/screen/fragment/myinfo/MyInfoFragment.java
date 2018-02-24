package com.example.parkminhyun.wannafootball.screen.fragment.myinfo;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class MyInfoFragment extends BaseFragment {

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

    @Override
    protected void initView() {
    }

    @Override
    protected void createPresenter() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_my_info;
    }

}
