package com.example.parkminhyun.wannafootball.common.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public abstract class BaseFragment extends Fragment {

    public View view;

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);

        createPresenter();
        initFragment(view);
        return view;
    }

    private void initFragment(View view){
        ButterKnife.bind(this,view);
        init();
    }

    protected abstract void init();

    protected abstract void createPresenter();

    protected abstract int getLayoutResId();

    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    protected void startActivityClearTop(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void startActivityThenKill(Class<?> cls, Bundle bundle) {
        startActivity(cls, bundle);
        getActivity().finish();
    }
}