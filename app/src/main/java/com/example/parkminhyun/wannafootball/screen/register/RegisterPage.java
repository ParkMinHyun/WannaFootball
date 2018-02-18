package com.example.parkminhyun.wannafootball.screen.register;

import com.google.firebase.database.DatabaseReference;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
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
