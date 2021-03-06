package com.example.parkminhyun.wannafootball.common.login;

import android.content.Context;

import com.example.parkminhyun.wannafootball.db.provider.ScreenSkipModelProvider;
import com.example.parkminhyun.wannafootball.db.provider.UserLoginModelProvider;
import com.nhn.android.naverlogin.OAuthLogin;

import static com.example.parkminhyun.wannafootball.common.constant.UserConstant.NOT_INPUTTED_USER_ID;

/**
 * Created by ParkMinHyun on 2018-02-25.
 */

public class LoginHelper {

    private static final String NAVER_CLIENT_ID = "ajkQnVpM4y94tf3XjIlw";
    private static final String NAVER_CLIENT_SECRET = "TyVWYW36Mr";
    private static final String NAVER_CLIENT_NAME = "DoYouWantToSoccer?";

    private static UserLoginModelProvider userLoginModelProvider;
    private static ScreenSkipModelProvider screenSkipModelProvider;

    private static OAuthLogin mOAuthLoginModule;

    // API 인스턴스를 초기화
    public static void initNaverAuthInstance(Context context) {
        mOAuthLoginModule = OAuthLogin.getInstance();
        mOAuthLoginModule.init(context, NAVER_CLIENT_ID, NAVER_CLIENT_SECRET, NAVER_CLIENT_NAME);
    }

    public static boolean isUserLoggedIn() {
        userLoginModelProvider = new UserLoginModelProvider();
        return userLoginModelProvider.getUserLoggedIn();
    }

    public static boolean isLoginScreenSkipStatus() {
        screenSkipModelProvider = new ScreenSkipModelProvider();
        return screenSkipModelProvider.getLoginScreenSkipStatus();
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
        userLoginModelProvider = new UserLoginModelProvider();
        userLoginModelProvider.updateUserLogin(userID, loginStatus);
    }

    public static void updatedLoggedInScreenSkip(boolean loggedInScreenSkipStatus) {
        screenSkipModelProvider = new ScreenSkipModelProvider();
        screenSkipModelProvider.updateLoginScreenSkipStatus(loggedInScreenSkipStatus);
    }

    public static OAuthLogin getOAuthLoginModule() {
        return mOAuthLoginModule;
    }

    public static String getAccessToken(Context context) {
        return mOAuthLoginModule.getAccessToken(context);
    }
}
