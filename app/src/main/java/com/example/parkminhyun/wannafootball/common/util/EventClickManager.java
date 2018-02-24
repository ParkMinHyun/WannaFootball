/**
* EventClickManager.java $version 1.0 2014 2014. 12. 16.
*
* Copyright 2014 NHN Corp. All rights Reserved.
* NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.example.parkminhyun.wannafootball.common.util;

import android.support.v4.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author hykim
 *
 */
public class EventClickManager {
	private static final int DEFAULT_CLICKABLE_TIME_MILLIS = 500;
	private static final int CACHE_SIZE = 1000;

	public static final LruCache<Integer, Long> sClickQueue = new LruCache<>(CACHE_SIZE);

	public static void setOnClickListener(View view, OnClickListener onClickListener) {
		setOnClickListener(view, null, onClickListener);
	}

	public static void setOnClickListener(View view, int[] viewIds, OnClickListener onClickListener) {
		if(view == null) {
			return;
		}

		view.setOnClickListener(onClickListener);

		if (viewIds == null || viewIds.length == 0) {
			return;
		}

		for (int id : viewIds) {
			View v = view.findViewById(id);

			if (v == null) {
				continue;
			}

			v.setOnClickListener(onClickListener);

		}
	}

	private static Long get(int key) {
		return sClickQueue.get(key);
	}

	private static void put(int key) {
		sClickQueue.put(key, System.currentTimeMillis());
	}

	public static boolean isClickable(View view, int clickableTimeMillis, boolean renew) {
		int key = view.hashCode();

		if (get(key) == null) {
			put(key);
			return true;
		}

		long diff = System.currentTimeMillis() - get(key);

		if (diff > clickableTimeMillis) {
			put(key);
			return true;
		}

		if(renew) {
			put(key);
		}

		return false;
	}

	public static boolean isClickable(View view, boolean renew) {
		return isClickable(view, DEFAULT_CLICKABLE_TIME_MILLIS, renew);
	}

	public static boolean isClickable(View view) {
		return isClickable(view, DEFAULT_CLICKABLE_TIME_MILLIS, false);
	}

	public static void clear() {
		sClickQueue.evictAll();
	}
}
