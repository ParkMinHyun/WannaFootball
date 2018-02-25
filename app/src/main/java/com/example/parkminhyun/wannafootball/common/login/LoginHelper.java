package com.example.parkminhyun.wannafootball.common.login;

import android.content.Context;
import android.os.AsyncTask;

import com.example.parkminhyun.wannafootball.data.UserVO;
import com.example.parkminhyun.wannafootball.db.provider.UserLoginModelProvider;
import com.nhn.android.naverlogin.OAuthLogin;

import java.util.concurrent.ExecutionException;

import static com.example.parkminhyun.wannafootball.common.constant.UserConstant.NOT_INPUTTED_USER_ID;

/**
 * Created by ParkMinHyun on 2018-02-25.
 */

public class LoginHelper {

    private static final String NAVER_CLIENT_ID = "ajkQnVpM4y94tf3XjIlw";
    private static final String NAVER_CLIENT_SECRET = "TyVWYW36Mr";
    private static final String NAVER_CLIENT_NAME = "DoYouWantToSoccer?";
    private static final String NAVER_USER_URL = "https://openapi.naver.com/v1/nid/me";

    private static UserLoginModelProvider userLoginModelProvider;
    private static OAuthLogin mOAuthLoginModule;

    // API 인스턴스를 초기화
    public static void initNaverAuthInstance(Context context) {
        mOAuthLoginModule = OAuthLogin.getInstance();
        mOAuthLoginModule.init(context, NAVER_CLIENT_ID, NAVER_CLIENT_SECRET, NAVER_CLIENT_NAME);
    }

    public static boolean isLoggedIn() {
        userLoginModelProvider = UserLoginModelProvider.getInstance();
        return userLoginModelProvider.getUserLoggedIn();
    }

    public static boolean isLoginScreenSkipped() {
        userLoginModelProvider = UserLoginModelProvider.getInstance();
        return userLoginModelProvider.getUserLoginScreenSkipStatus();
    }

    public static boolean naverLogout(Context context) {
        initNaverAuthInstance(context);
        if (mOAuthLoginModule.logoutAndDeleteToken(context)) {
            updateUserLogin(NOT_INPUTTED_USER_ID, false);
            return true;
        }
        return false;
    }

    public static void updateUserLogin(String userID, boolean loginStatus) {
        userLoginModelProvider = UserLoginModelProvider.getInstance();
        userLoginModelProvider.updateUserLogin(userID, loginStatus);
    }

    public static OAuthLogin getOAuthLoginModule() {
        return mOAuthLoginModule;
    }

    public static String getAccessToken(Context context) {
        return mOAuthLoginModule.getAccessToken(context);
    }

    public static String naverRequestApi(Context context, String accessToken) {
        return mOAuthLoginModule.requestApi(context, accessToken, NAVER_USER_URL);
    }

    public static UserVO naverUserInfo(Context context) {
        UserVO myInfoVO = null;
        try {
            NaverRequestAPITask naverRequestAPITask = new NaverRequestAPITask(getAccessToken(context));
            myInfoVO = naverRequestAPITask.execute().get();

            // AsyncTask 종료시켜 주기
            if (naverRequestAPITask.getStatus() == AsyncTask.Status.RUNNING) {
                naverRequestAPITask.cancel(true);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return myInfoVO;
    }
}
