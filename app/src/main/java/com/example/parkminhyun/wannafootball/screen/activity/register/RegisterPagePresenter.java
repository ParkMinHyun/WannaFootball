package com.example.parkminhyun.wannafootball.screen.activity.register;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import com.example.parkminhyun.wannafootball.App;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
 * 현재 사용하지 않는 Class 추후 참고를 위해 남겨놓음.
 */

public class RegisterPagePresenter implements RegisterPage.Presenter {

    private RegisterPage.View registerView;
    private RegisterPageModel registerModel;

    private DatabaseReference databaseUser;
    public static final String USER_LOGIN = "user";

    private boolean isEmailDupChecked = false;
    private boolean isPasswordChecked = false;

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
                    isPasswordChecked = true;
                else
                    isPasswordChecked = false;

                registerView.changePasswordColor(isPasswordChecked);
            }
        };
        loginPasswordCheckText.addTextChangedListener(textWatcher);
    }

    @Override
    public void onClickEmailDuplicationCheckButton(MaterialEditText emailText) {
        String currentEmail = emailText.getText().toString();
        Query query = databaseUser.orderByChild("email");
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    RegisterPageModel userVO = postSnapshot.getValue(RegisterPageModel.class);
                    if (userVO.getEmail().equals(currentEmail)) {
                        isEmailDupChecked = false;
                        Log.i("중복", "중복되네요.");
                        return;
                    }
                }
                isEmailDupChecked = true;
                registerModel.setEmail(currentEmail);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    @Override
    public void onClickSignUpButton() {

        if (!isEmailDupChecked) {
            Toast.makeText(App.getInstance(), "Email 중복검사하세욧", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isPasswordChecked) {
            Toast.makeText(App.getInstance(), "비밀번호 체크하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("회원 등록", registerModel.getEmail() + '\n' + registerModel.getPassword());
        String id = databaseUser.push().getKey();
        databaseUser.child(id).setValue(registerModel);
        registerView.finishActivity();
    }

    @Override
    public void setFireBaseReference(DatabaseReference databaseUser) {
        this.databaseUser = databaseUser;
    }

}
