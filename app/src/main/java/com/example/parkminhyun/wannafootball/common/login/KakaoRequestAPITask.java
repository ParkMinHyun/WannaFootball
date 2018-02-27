package com.example.parkminhyun.wannafootball.common.login;

import android.util.Log;

import com.example.parkminhyun.wannafootball.data.UserVO;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;

/**
 * Created by ParkMinHyun on 2018-02-27.
 */

public class KakaoRequestAPITask {

    private static final String TAG = "KAKAO_LOGIN";

    public UserVO requestProfile(){
        UserVO userVO = new UserVO();

        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                Log.e(TAG, "error message=" + errorResult);
//                super.onFailure(errorResult);
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {

                Log.d(TAG, "onSessionClosed1 =" + errorResult);
            }

            @Override
            public void onNotSignedUp() {
                //카카오톡 회원이 아닐시
                Log.d(TAG, "onNotSignedUp ");

            }

            @Override
            public void onSuccess(UserProfile result) {
                Log.e("UserProfile", result.toString());
                Log.e("UserProfile", result.getId() + "");
            }
        });

        return userVO;
    }
}
