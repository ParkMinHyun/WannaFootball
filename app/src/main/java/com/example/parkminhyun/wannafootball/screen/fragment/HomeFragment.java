package com.example.parkminhyun.wannafootball.screen.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parkminhyun.wannafootball.R;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class HomeFragment extends BaseFragment {

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initView(View view) {}


    @Override
    protected void createPresenter() {

    }

}
