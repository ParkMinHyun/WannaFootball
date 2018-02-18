/*
 * RealmQueryTask.java 2017. 07. 20
 *
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.example.parkminhyun.wannafootball.db.core;

import io.realm.Realm;

/**
 * Created by ParkMinHyun on 2018-02-18.
 */

public interface RealmQueryTask<T> {

    T queryResult(Realm realm);

}
