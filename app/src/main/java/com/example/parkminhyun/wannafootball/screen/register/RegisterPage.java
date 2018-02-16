package com.example.parkminhyun.wannafootball.screen.register;

import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public interface RegisterPage {

    interface View {
        void changePasswordColor(boolean isChecked);
    }

    interface Presenter {
        void passwordCheckWatcher(MaterialEditText loginPasswordText,
                                  MaterialEditText loginPasswordCheckText);

    }

}
