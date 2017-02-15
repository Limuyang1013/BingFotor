package com.wallpaper.bingfotor.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by Limuyang on 2017/2/15.
 */

/**
 * 判断字符串是否为null或空 *
 *
 */

public class StringUtils {
    public static boolean isNullOrEmpty(String string) {
        boolean flag = false;
        if (null == string || string.trim().length() == 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 获取屏幕宽度 * * @param activity * @return
     */
    public static int getWidth(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        return width;
    }

}
