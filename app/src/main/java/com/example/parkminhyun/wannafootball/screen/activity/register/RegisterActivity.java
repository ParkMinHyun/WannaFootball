package com.example.parkminhyun.wannafootball.screen.activity.register;

import android.app.Activity;
import android.view.View;

import com.example.parkminhyun.wannafootball.screen.activity.BaseActivity;
import com.example.parkminhyun.wannafootball.MainApplication;
import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.customview.RangeScaleTextView;
import com.example.parkminhyun.wannafootball.common.util.AnimationDirection;
import com.google.firebase.database.DatabaseReference;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.parkminhyun.wannafootball.screen.activity.register.RegisterPagePresenter.USER_LOGIN;

/**
 * 현재 사용하지 않는 Class 추후 참고를 위해 남겨놓음.
 */

public class RegisterActivity extends BaseActivity implements RegisterPage.View {

    @BindView(R.id.registerEmailText)
    MaterialEditText emailText;

    @BindView(R.id.registerPasswordText)
    MaterialEditText passwordText;

    @BindView(R.id.registerPasswordCheckText)
    MaterialEditText passwordCheckText;

    @BindView(R.id.emailDuplicationCheckButton)
    View emailDuplicationCheckButton;

    @BindView(R.id.signUpButton)
    View signUpButton;

    @BindView(R.id.passwordCorrect)
    RangeScaleTextView passwordCorrect;

    @BindView(R.id.passwordNotCorrect)
    RangeScaleTextView passwordNotCorrect;

    private RegisterPage.Presenter registerPresenter;
    private DatabaseReference databaseUser;

    @Override
    public void initView(){
        initPasswordText();
        initFireBaseReference();
    }

    @Override
    protected void initPresenter() {}

    private void initPasswordText() {
        registerPresenter.passwordCheckWatcher(passwordText, passwordCheckText);
    }

    private void initFireBaseReference() {
        databaseUser = MainApplication.getFirebaseDatabase().getReference(USER_LOGIN);
        registerPresenter.setFireBaseReference(databaseUser);
    }

    @OnClick({R.id.emailDuplicationCheckButton, R.id.signUpButton})
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.emailDuplicationCheckButton){
            registerPresenter.onClickEmailDuplicationCheckButton(emailText);
        }
        else if( id == R.id.signUpButton){
            registerPresenter.onClickSignUpButton();
        }
    }

    @Override
    public void changePasswordColor(boolean isChecked) {
        if(isChecked){
            passwordCorrect.setVisibility(View.VISIBLE);
            passwordNotCorrect.setVisibility(View.GONE);
        }
        else{
            passwordNotCorrect.setVisibility(View.VISIBLE);
            passwordCorrect.setVisibility(View.GONE);
        }
    }

    @Override
    public void finishActivity() {
        this.finish();
    }

    @Override
    protected void createPresenter() { registerPresenter = new RegisterPagePresenter(this); }

    @Override
    protected Activity getViews() { return this; }

    @Override
    protected int getLayout() { return R.layout.activity_register; }

    @Override
    protected AnimationDirection getAnimationDirection(){ return AnimationDirection.RIGHT; }
}
