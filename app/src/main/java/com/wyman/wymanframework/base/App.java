package com.wyman.wymanframework.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.wyman.wymanframework.BuildConfig;
import com.wyman.wymanframework.di.component.ApplicationComponent;
import com.wyman.wymanframework.di.component.DaggerApplicationComponent;
import com.wyman.wymanframework.di.module.ApplicationModule;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * @author wyman
 * @date 2018/4/11
 * description :
 */

public class App extends Application {
    private static App mInstance;
    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initApplicationComponent();
        Fragmentation.builder().stackViewMode(Fragmentation.BUBBLE).debug(true).install();
        //是否打印日志
//        LogUtils.isDebug = BuildConfig.DEBUG;
        initARouter();
        Utils.init(this);




    }
    /**
     * 初始化路由
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    public static App getInstance() {
        return mInstance;
    }
}
