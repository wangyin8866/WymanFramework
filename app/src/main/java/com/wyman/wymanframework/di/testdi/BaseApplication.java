package com.wyman.wymanframework.di.testdi;

import android.app.Application;
import android.content.Context;

/**
 * @author wyman
 * @date 2018/5/18
 * description :
 */

public class BaseApplication extends Application{
    public  static BaseApplication application;
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mContext = application.getApplicationContext();
    }
}
