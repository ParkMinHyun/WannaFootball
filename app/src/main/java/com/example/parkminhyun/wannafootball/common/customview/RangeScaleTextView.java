/*
 * RangeScaleTextView.java 2017. 06. 25
 *
 * Copyright 2017 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.example.parkminhyun.wannafootball.common.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.example.parkminhyun.wannafootball.R;

/**
 * Created by ParkMinHyun on 2018-02-15.
 */

public class RangeScaleTextView extends AppCompatTextView {

    private static final int DEFAULT_MIN_TEXT_PIXEL_SIZE = 0;
    private static final int DEFAULT_MAX_TEXT_PIXEL_SIZE = 100;

    public RangeScaleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RangeScaleTextView);
        int minPixelSize = ta.getDimensionPixelSize(R.styleable.RangeScaleTextView_minDpSize, DEFAULT_MIN_TEXT_PIXEL_SIZE);
        int maxPixelSize = ta.getDimensionPixelSize(R.styleable.RangeScaleTextView_maxDpSize, DEFAULT_MAX_TEXT_PIXEL_SIZE);
        ta.recycle();

        float textSize = getTextSize();
        float fontScale = getResources().getConfiguration().fontScale;
        float realTextSize = textSize * fontScale;

        // 시스템 설정(Configuration Changed)에 의한 Font Scale 변경에 따른 텍스트 크기 변화를
        // 일정 Pixel 내에서만 진행되도록 처리한다.
        if (realTextSize > maxPixelSize) {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, maxPixelSize);
        } else if (realTextSize < minPixelSize) {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, minPixelSize);
        }
    }
}