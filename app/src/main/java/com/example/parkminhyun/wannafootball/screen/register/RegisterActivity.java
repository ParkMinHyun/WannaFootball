package com.example.parkminhyun.wannafootball.screen.register;

import android.app.Activity;
import android.view.View;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterPage.View {


    @BindView(R.id.loginIdText)
    MaterialEditText loginIdText;

    @BindView(R.id.loginPasswordText)
    MaterialEditText loginPasswordText;

    @BindView(R.id.loginPasswordCheckText)
    MaterialEditText loginPasswordCheckText;

    @BindView(R.id.emailDuplicationCheckButton)
    View emailDuplicationCheckButton;

    @BindView(R.id.signUpButton)
    View signUpButton;

    RegisterPage.Presenter registerPresenter;

    @OnClick({R.id.emailDuplicationCheckButton, R.id.signUpButton})
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.emailDuplicationCheckButton){

        }
        else if( id == R.id.signUpButton){

        }
    }

    @Override
    public void initView(BaseActivity context){

    }

    @Override
    protected void createPresenter() { registerPresenter = new RegisterPagePresenter(this); }

    @Override
    protected Activity getViews() { return this; }

    @Override
    protected int getLayout() { return R.layout.activity_register; }

}
