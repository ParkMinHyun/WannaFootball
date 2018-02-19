package com.example.parkminhyun.wannafootball.screen.activity.register;

import com.google.firebase.database.DatabaseReference;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
 * 현재 사용하지 않는 Class 추후 참고를 위해 남겨놓음.
 */

public interface RegisterPage {

    interface View {
        void changePasswordColor(boolean isChecked);

        void finishActivity();
    }

    interface Presenter {
        void passwordCheckWatcher(MaterialEditText loginPasswordText,
                                  MaterialEditText loginPasswordCheckText);

        void onClickSignUpButton();

        void onClickEmailDuplicationCheckButton(MaterialEditText emailText);

        void setFireBaseReference(DatabaseReference databaseUser);
    }

}
