package com.example.parkminhyun.wannafootball.screen.fragment.team;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class SearchTeamPresenter implements SearchTeamInterface.Presenter {

    private SearchTeamInterface.View searchTeamView;

    @Override
    public void setSearchTextWatcher(EditText teamSearchText) {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(teamSearchText.getText().length() == 0){
                    // TODO: Text 길이가 0일 때.
                }
            }
        };
    }

    @Override
    public void setTeamRecyclerView(RecyclerView teamRecyclerView) {

    }

    public SearchTeamPresenter(SearchTeamInterface.View searchTeamView) {
        this.searchTeamView = searchTeamView;
    }
}
