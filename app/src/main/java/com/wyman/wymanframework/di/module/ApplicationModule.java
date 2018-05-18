package com.wyman.wymanframework.di.module;

import android.content.Context;

import com.wyman.wymanframework.base.App;
import com.wyman.wymanframework.di.scope.ContextLife;
import com.wyman.wymanframework.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@Module
public class ApplicationModule {
    private App mApplication;

    public ApplicationModule(App mApplication) {
        this.mApplication = mApplication;
    }
    @PerApp
    @Provides
    @ContextLife("Application")
    public Context provideApplicationContext(){
        return mApplication.getApplicationContext();
    }
}
