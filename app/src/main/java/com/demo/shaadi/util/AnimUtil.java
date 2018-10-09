package com.demo.shaadi.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.demo.shaadi.R;

public class AnimUtil {
  public static void animateItemRemove(Context context,View itemView){
    Animation animation= AnimationUtils.loadAnimation(context, R.anim.item_to_right);
    itemView.startAnimation(animation);
  }
}
