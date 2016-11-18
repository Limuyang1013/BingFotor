package com.wallpaper.bingfotor;

import android.app.Application;

import com.google.gson.Gson;

/**
 * Created by Limuyang on 2016/11/18.
 */

public class BingFotorApplication extends Application {
    private static Gson gson;

    public static Gson gsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
}
