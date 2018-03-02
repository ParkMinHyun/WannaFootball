package com.example.parkminhyun.wannafootball.screen.fragment.team;

import android.view.View;
import android.widget.EditText;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.base.BaseFragment;
import com.example.parkminhyun.wannafootball.common.util.EventClickManager;
import com.hanks.library.AnimateCheckBox;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class SearchTeamFragment extends BaseFragment implements SearchTeamInterface.View {


    @BindView(R.id.locationTypeCheckView)
    View locationTypeCheckView;

    @BindView(R.id.teamNameTypeCheckView)
    View teamNameTypeCheckView;

    @BindView(R.id.locationTypeCheck)
    AnimateCheckBox locationTypeCheckBox;

    @BindView(R.id.teamNameTypeCheck)
    AnimateCheckBox teamNameTypeCheckBox;

    @BindView(R.id.teamSearchText)
    EditText teamSearchText;

    private SearchTeamPresenter searchTeamPresenter;

    @Override
    protected void init() {
        searchTeamPresenter.initPresenter();
    }

    @Override
    public void initView() {
        locationTypeCheckBox.setChecked(true);
    }

    @OnClick({R.id.locationTypeCheckView, R.id.teamNameTypeCheckView})
    void onClick(View view) {
        if (!EventClickManager.isClickable(view)) {
            return;
        }

        switch (view.getId()) {
            case R.id.locationTypeCheckView:
                locationTypeCheckBox.setChecked(!locationTypeCheckBox.isChecked());
                break;
            case R.id.teamNameTypeCheckView:
                teamNameTypeCheckBox.setChecked(!teamNameTypeCheckBox.isChecked());
                break;
            default:
                break;
        }
    }


    @Override
    protected void createPresenter() {
        searchTeamPresenter = new SearchTeamPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_search_team;
    }
}
