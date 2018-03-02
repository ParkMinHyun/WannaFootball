package com.example.parkminhyun.wannafootball.screen.fragment.match.search;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.base.BaseFragment;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class SearchMatchingFragment extends BaseFragment implements SearchMatchInterface.View{

    SearchMatchPresenter searchMatchPresenter;
    @Override
    protected void init() {
        searchMatchPresenter.initPresenter();
    }

    @Override
    protected void createPresenter() {
        this.searchMatchPresenter = new SearchMatchPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_search_matching_team;
    }
}
