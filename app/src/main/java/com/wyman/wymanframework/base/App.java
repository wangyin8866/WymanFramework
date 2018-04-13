package com.wyman.wymanframework.base;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.wyman.wymanframework.BuildConfig;
import com.wyman.wymanframework.utils.LogUtils;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * @author wyman
 * @date 2018/4/11
 * description :
 */

public class App extends Application {
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Fragmentation.builder().stackViewMode(Fragmentation.BUBBLE).debug(true).install();
        //是否打印日志
        LogUtils.isDebug = BuildConfig.IS_SHOW_LOG;
        Utils.init(this);

    }

    public static App getInstance() {
        return mInstance;
    }
}
