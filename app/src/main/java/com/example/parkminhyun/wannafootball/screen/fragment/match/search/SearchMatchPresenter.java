package com.example.parkminhyun.wannafootball.screen.fragment.match.search;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class SearchMatchPresenter implements SearchMatchInterface.Presenter {

    private SearchMatchInterface.View searchMatchView;

    public SearchMatchPresenter(SearchMatchInterface.View searchMatchView) {
        this.searchMatchView = searchMatchView;
    }

    @Override
    public void initPresenter() {
    }
}
