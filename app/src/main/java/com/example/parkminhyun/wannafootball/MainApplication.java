package com.example.parkminhyun.wannafootball;

import android.app.Application;
import android.content.Context;

import com.google.firebase.database.FirebaseDatabase;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class MainApplication extends Application {

    private static MainApplication instance;

    private static FirebaseDatabase firebaseDatabase;
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
        initFireBase();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(APP_NAME)
                .directory(getFilesDir())
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void initFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public static MainApplication getInstance() {
        return instance;
    }

    public static Realm getRealmInstance(){ return Realm.getDefaultInstance(); }
    public static FirebaseDatabase getFirebaseDatabase() { return firebaseDatabase; }
}
