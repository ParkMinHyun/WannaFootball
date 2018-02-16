package com.example.parkminhyun.wannafootball.screen.register;

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
            public void afterTextChanged(Editable edit) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // 입력된 password가 model에 저장된 password와 다를 경우에만 password 변경.
                String passwordString = loginPasswordText.getText().toString();
                if (passwordString != null) {
                    if (!passwordString.equals(registerModel.getPassword()))
                        registerModel.setPassword(passwordString);
                }
            }

            @Override
            public void onTextChanged(CharSequence passwordCheckString, int start, int before, int count) {

                if (registerModel.getPassword() == null)
                    return;

                if (passwordCheckString.toString().equals(registerModel.getPassword()))
                    registerView.changePasswordColor(true);
                else
                    registerView.changePasswordColor(false);
            }
        };
        loginPasswordCheckText.addTextChangedListener(textWatcher);
    }

}
