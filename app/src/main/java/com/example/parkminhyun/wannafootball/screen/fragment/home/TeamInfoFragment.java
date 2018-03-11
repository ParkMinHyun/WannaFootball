package com.example.parkminhyun.wannafootball.screen.fragment.home;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.base.BaseFragment;
import com.example.parkminhyun.wannafootball.common.customview.RiceCakeView;
import com.example.parkminhyun.wannafootball.common.util.EventClickManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ParkMinHyun on 2018-02-20.
 */

public class TeamInfoFragment extends BaseFragment implements TeamInfoInterface.View{

    @BindView(R.id.userTeamInfoLayout) View userTeamInfoLayout;
    @BindView(R.id.userNotTeamInfoLayout) View userNotTeamInfoLayout;

    @BindView(R.id.createTeamButton) Button createTeamButton;

    // TODO: Layout 하나 따로 생성해서 분리 시키기
    @BindView(R.id.reviseTeamInfoButton) TextView reviseTeamInfoButton;
    @BindView(R.id.teamPhotoView) ImageView teamPhotoView;
    @BindView(R.id.teamNameView) TextView teamNameView;
    @BindView(R.id.teamScoreView) TextView teamScoreView;
    @BindView(R.id.teamLeaderNameView) TextView teamLeaderNameView;
    @BindView(R.id.teamNumberView) TextView teamNumberView;
    @BindView(R.id.matchRegisterBox) RiceCakeView matchRegisterBox;
    @BindView(R.id.enrollTeamBox) RiceCakeView enrollTeamBox;
    @BindView(R.id.teamCommandBox) RiceCakeView teamCommandBox;

    private TeamInfoPresenter teamInfoPresenter;

    @Override
    protected void init() {
        initView();
    }

    private void initView() {
        userNotTeamInfoLayout.setVisibility(View.VISIBLE);
        userTeamInfoLayout.setVisibility(View.GONE);
    }

    @OnClick({R.id.createTeamButton})
    void onClick(View view) {
        if (!EventClickManager.isClickable(view)) {
            return;
        }

        switch (view.getId()) {
            case R.id.createTeamButton:
                teamInfoPresenter.onClickCreateTeamButton();
                break;
            default:
                break;
        }
    }

    @Override
    protected void createPresenter() { teamInfoPresenter = new TeamInfoPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_team_info;
    }
}
