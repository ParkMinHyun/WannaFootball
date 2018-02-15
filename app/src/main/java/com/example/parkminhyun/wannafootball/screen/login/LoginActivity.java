package com.example.parkminhyun.wannafootball.screen.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.parkminhyun.wannafootball.R;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginPage.View{

    @BindView(R.id.searchPasswordButton)
    TextView searchPasswordButton;

    @BindView(R.id.registerButton)
    TextView registerButton;

    LoginPage.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPagePresenter(this);
        loginPresenter.initUserData();
    }

    @OnClick({R.id.searchPasswordButton, R.id.registerButton})
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.searchPasswordButton) {
        } else if (id == R.id.registerButton) {
        }
    }

}
