package com.example.parkminhyun.wannafootball.screen.fragment.match.enroll;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class EnrollMatchPresenter implements EnrollMatchInterface.Presenter {

    private EnrollMatchInterface.View enrollMatchView;

    public EnrollMatchPresenter(EnrollMatchInterface.View enrollMatchView) {
        this.enrollMatchView = enrollMatchView;
    }

}
