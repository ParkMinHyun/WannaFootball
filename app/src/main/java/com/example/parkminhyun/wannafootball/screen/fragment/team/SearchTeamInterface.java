package com.example.parkminhyun.wannafootball.screen.fragment.team;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public interface SearchTeamInterface {

    interface View {
    }

    interface Presenter {
        void setSearchTextWatcher(EditText teamSearchText);

        void setTeamRecyclerView(RecyclerView teamRecyclerView);
    }

}
