package com.xp.zlpay;

import android.app.Application;
import android.content.Context;

/**
 * Author YC
 * 2017/7/6 0006.
 */

public class MyApplication extends Application {
    private static final  String TAG = MyApplication.class.getName();

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getInstance(){
        return mContext;
    }
}
