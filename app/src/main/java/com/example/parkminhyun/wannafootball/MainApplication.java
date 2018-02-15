package com.example.parkminhyun.wannafootball;

import android.app.Application;
import android.content.Context;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class MainApplication extends Application {

    private static MainApplication instance;
    private static final String APP_NAME = "WannaFootball";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initLibraries();
    }

    private void initLibraries() {
        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(APP_NAME)
                .directory(getFilesDir())
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public static MainApplication getInstance() {
        return instance;
    }

}
