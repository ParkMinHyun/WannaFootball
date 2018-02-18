package com.example.parkminhyun.wannafootball.common.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

import com.example.parkminhyun.wannafootball.R;

/**
 * Created by Naver on 2018-02-17.
 */

public class RiceCakeAnimationUtils {
    public static final String TAG = RiceCakeAnimationUtils.class.getSimpleName();
    public static final float SCALE_DOWN_RATIO = 0.9f;
    public static final float SCALE_ORIGINAL_RATIO = 1f;
    public static final float SCALE_UP_REVERSE_RATIO = 1.1f; // 눌렀을때 커졌다가 작아질때는 조금 더 작은 사이즈로 시작되야함.
    public static final float PIVOT_CENTER = 0.5f;

    /**
     * 눌렀을때 작아지는 효과를 위한 애니메이션
     */
    public static void viewDownScaleDown(final View view, int durationMilli) {

        try {

            ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", SCALE_DOWN_RATIO);
            ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", SCALE_DOWN_RATIO);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(durationMilli);
            animatorSet.playTogether(scaleDownX, scaleDownY);
            animatorSet.start();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 눌렀을때 작아졌다가 다시 뗏을때 커지는 효과.
     */
    public static void viewDownScaleUp(final View view, int durationMilli) {

        try {
            //loadAnimation으로는 제대로 동작하지 않아서 ScaleAnimation을 생성하여 사용합니다.
            //Animation scaleUpAni =  AnimationUtils.loadAnimation(view.getContext(), R.anim.scale_up);

            ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(view, "scaleX", SCALE_ORIGINAL_RATIO);
            ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(view, "scaleY", SCALE_ORIGINAL_RATIO);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(durationMilli);
            animatorSet.playTogether(scaleUpX, scaleUpY);
            animatorSet.start();

			/*Animation scaleUpAni = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
            scaleUpAni.setInterpolator(new DecelerateInterpolator());
			scaleUpAni.setDuration(durationMilli);
			view.startAnimation(scaleUpAni);*/
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 눌렀을때 커지는 효과를 위한 애니메이션
     */
    public static void viewUpScaleDown(final View view, int durationMilli) {

        try {
            Animation scaleDownAni = AnimationUtils.loadAnimation(view.getContext(), R.anim.up_scale_down);
            scaleDownAni.setDuration(durationMilli);
            scaleDownAni.setFillAfter(true);
            view.startAnimation(scaleDownAni);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    /**
     * 눌렀을때 커졌다가 다시 뗏을때 작아지는 효과.
     */
    public static void viewUpScaleUp(final View view, int durationMilli) {

        try {
            //loadAnimation으로는 제대로 동작하지 않아서 ScaleAnimation을 생성하여 사용합니다.
            //Animation scaleUpAni =  AnimationUtils.loadAnimation(view.getContext(), R.anim.scale_up);
            Animation scaleUpAni = new ScaleAnimation(SCALE_UP_REVERSE_RATIO, 1f, SCALE_UP_REVERSE_RATIO, 1f, Animation.RELATIVE_TO_SELF, PIVOT_CENTER, Animation.RELATIVE_TO_SELF, PIVOT_CENTER);
            scaleUpAni.setInterpolator(new DecelerateInterpolator());
            scaleUpAni.setDuration(durationMilli);
            view.startAnimation(scaleUpAni);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}