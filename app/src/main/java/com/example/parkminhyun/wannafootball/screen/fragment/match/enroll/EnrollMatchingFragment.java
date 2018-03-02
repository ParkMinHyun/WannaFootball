package com.example.parkminhyun.wannafootball.screen.fragment.match.enroll;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.base.BaseFragment;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class EnrollMatchingFragment extends BaseFragment implements EnrollMatchInterface.View {

    private EnrollMatchPresenter enrollMatchPresenter;

    @Override
    protected void init() {
        enrollMatchPresenter.initPresenter();
    }

    @Override
    protected void createPresenter() {
        this.enrollMatchPresenter = new EnrollMatchPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_enroll_matching;
    }
}
