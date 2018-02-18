package com.example.parkminhyun.wannafootball.screen.login;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.parkminhyun.wannafootball.BaseActivity;
import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.screen.main.MainActivity;
import com.example.parkminhyun.wannafootball.screen.register.RegisterActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginPage.View {

    @BindView(R.id.loginEmailText)
    MaterialEditText loginEmailText;

    @BindView(R.id.loginPasswordText)
    MaterialEditText loginPasswordText;

    @BindView(R.id.loginImageView)
    View loginImageView;

    @BindView(R.id.searchPasswordButton)
    TextView searchPasswordButton;

    @BindView(R.id.registerButton)
    TextView registerButton;

    LoginPage.Presenter loginPresenter;

    @OnClick({R.id.loginImageView, R.id.searchPasswordButton, R.id.registerButton})
    public void onClick(View view) {
        int id = view.getId();

        if( id == R.id.loginImageView){
            loginPresenter.loginCheck(loginEmailText,loginPasswordText);
        }
        else if (id == R.id.searchPasswordButton) {

        } else if (id == R.id.registerButton) {
            startRegisterActivity();
        }
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void startRegisterActivity(){
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void createPresenter() { loginPresenter = new LoginPagePresenter(this); }

    @Override
    protected Activity getViews() { return this; }

    @Override
    protected int getLayout() { return R.layout.activity_login; }

}
