package com.example.parkminhyun.wannafootball.screen.register;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;

import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class RegisterPagePresenter implements RegisterPage.Presenter {

    RegisterPage.View registerView;
    RegisterPageModel registerModel;

    public RegisterPagePresenter(RegisterPage.View registerView) {
        this.registerView = registerView;
        this.registerModel = new RegisterPageModel();
    }

    /**
     * Password 체크 상태를 실시간으로 확인하는 Method.
     */
    @Override
    public void passwordCheckWatcher(final MaterialEditText loginPasswordText,
                                     final MaterialEditText loginPasswordCheckText) {

        final TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                String passwordString = loginPasswordText.getText().toString();
                if(passwordString != null) {
                    registerModel.setPassword(passwordString);
                }
            }

            @Override
            public void onTextChanged(CharSequence passwordCheckString, int start, int before,
                                      int count) {

                if (registerModel.getPassword() == null){
                    return;
                }

                if(passwordCheckString.toString().equals(registerModel.getPassword())){
                    // TODO : Hint 색상 Activity (View)에서 변경시키기 - 현재는 Presenter에서 변경하고 있음.
                    loginPasswordCheckText.setTextColor(Color.BLUE);
                }
                else{
                    // TODO : 본래색으로 변경하기.
                }
            }
        };
        loginPasswordCheckText.addTextChangedListener(textWatcher);
    }

}
