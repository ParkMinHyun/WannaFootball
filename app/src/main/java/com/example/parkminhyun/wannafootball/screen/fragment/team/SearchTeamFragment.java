package com.example.parkminhyun.wannafootball.screen.fragment.team;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.base.BaseFragment;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class SearchTeamFragment extends BaseFragment implements SearchTeamInterface.View {

    private SearchTeamPresenter searchTeamPresenter;

    @Override
    protected void init() {
        searchTeamPresenter.initPresenter();
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
