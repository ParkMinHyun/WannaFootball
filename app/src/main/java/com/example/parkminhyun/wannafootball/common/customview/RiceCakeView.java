package com.example.parkminhyun.wannafootball.common.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.parkminhyun.wannafootball.R;
import com.example.parkminhyun.wannafootball.common.util.RiceCakeAnimationUtils;

/**
 * Created by ParkMinHyun on 2018-02-17.
 */

public class RiceCakeView extends AppCompatImageView {

    public static final int FAST_DURATION_MILLI = 60;
    public static final double TOUCH_EXTRA_AREA_RATIO = 0.2;

    interface OnPressedListener {
        void onPressed(View view, MotionEvent ev);

        void onUp(View view, MotionEvent ev);

        void onCancel(View view, MotionEvent ev);
    }

    private OnClickListener onClickListener;
    private boolean reverseAnimation = false;
    private OnPressedListener onPressedListener;
    private OnClickListener onClickDisabledListener;

    private boolean pressAnimationIsDone = true;
    private boolean isLongClick = false;
    private final Runnable longClickCallback = () -> {
        if (isLongClick) {
            performLongClick();
            isLongClick = false;
        }
    };

    public RiceCakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RiceCakeView);
        reverseAnimation = typedArray.getBoolean(R.styleable.RiceCakeView_reverseAnimation, false);
        typedArray.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (!isEnabled()) {
            if (event.getAction() == MotionEvent.ACTION_UP && onClickDisabledListener != null) {
                onClickDisabledListener.onClick(this);
            }
            return true;
        }

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (isPressed()) {
                return false;
            }
            setPressed(true);
            onPressedDown(event);
            isLongClick = true;
            removeCallbacks(longClickCallback);
            postDelayed(longClickCallback, 1000);
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            isLongClick = false;
            if (isPressed()) {
                //change faster on up
                onPressCanceled(10);
            }
            setPressed(false);
            if (containsTouchInsideView(this, event, true) && onClickListener != null) {
                onClickListener.onClick(this);
            }
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (containsTouchInsideView(this, event, false)) {
                if (isPressed()) {
                    return false;
                }
                setPressed(true);
                onPressedDown(event);
                return false;
            } else {
                if (!isPressed()) {
                    return false;
                }
                setPressed(false);
                onPressCanceled(FAST_DURATION_MILLI);
                return false;
            }
        }

        return super.onTouchEvent(event);
    }

    public void onPressCanceled(final int durationMilli) {
        if (reverseAnimation) {

            if (pressAnimationIsDone) {
                RiceCakeAnimationUtils.viewUpScaleUp(this, durationMilli);
            } else {
                postDelayed(() -> RiceCakeAnimationUtils.viewUpScaleUp(RiceCakeView.this, durationMilli), FAST_DURATION_MILLI);
            }

        } else {
            if (pressAnimationIsDone) {
                RiceCakeAnimationUtils.viewDownScaleUp(this, durationMilli);
            } else {
                postDelayed(() -> RiceCakeAnimationUtils.viewDownScaleUp(RiceCakeView.this, durationMilli), FAST_DURATION_MILLI);
            }
        }
    }

    public void onPressedDown(MotionEvent event) {
        pressAnimationIsDone = false;
        if (onPressedListener != null) {
            onPressedListener.onPressed(this, event);
        }
        if (reverseAnimation) {
            RiceCakeAnimationUtils.viewUpScaleDown(this, FAST_DURATION_MILLI);
        } else {
            RiceCakeAnimationUtils.viewDownScaleDown(this, FAST_DURATION_MILLI);
        }
        postDelayed(() -> pressAnimationIsDone = true, FAST_DURATION_MILLI);
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    /**
     * set onClickLisener on disabled View.
     * eg) you can give a explanation with toast why this button is disabled
     */
    public void setOnClickDisabledListener(OnClickListener onClickDisabledListener) {
        this.onClickDisabledListener = onClickDisabledListener;
    }

    /**
     * @param addExtraSpace 추가 영역만큼도 true로 돌려줌
     */
    public boolean containsTouchInsideView(View view, MotionEvent ev, boolean addExtraSpace) {
        if (!view.isShown()) {
            return false;
        }

        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);

        if (addExtraSpace) {
            int horizontalExtra = (int) ((rect.right - rect.left) * TOUCH_EXTRA_AREA_RATIO);
            int verticalExtra = (int) ((rect.bottom - rect.top) * TOUCH_EXTRA_AREA_RATIO);
            rect.set(rect.left - horizontalExtra, rect.top - verticalExtra, rect.right + horizontalExtra, rect.bottom + verticalExtra);
        }

        return rect.contains((int) ev.getX(), (int) ev.getY());

    }

    public void setReverseAnimation(boolean reverseAnimation) {
        this.reverseAnimation = reverseAnimation;
    }

    public void setOnViewPressedListener(OnPressedListener onPressedListener) {
        this.onPressedListener = onPressedListener;
    }

}