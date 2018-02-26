package com.example.parkminhyun.wannafootball.db.dao;

import com.example.parkminhyun.wannafootball.App;
import com.example.parkminhyun.wannafootball.db.core.RealmQueryTask;
import com.example.parkminhyun.wannafootball.db.core.RealmTransactionTask;

import io.realm.Realm;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public class BaseRealmDAO {

    protected <T> T query(RealmQueryTask<T> task) {
        Realm realm = App.getRealmInstance();
        T result = null;
        try {
            result = task.queryResult(realm);
        } catch (Exception ex) {
        }
        realm.close();
        return result;
    }

    protected void modify(RealmTransactionTask task) {
        Realm realm = App.getRealmInstance();
        try {
            realm.beginTransaction();
            task.executeTransaction(realm);
            realm.commitTransaction();
        } catch (Exception ex) {
            realm.cancelTransaction();
        }
        realm.close();
    }

}