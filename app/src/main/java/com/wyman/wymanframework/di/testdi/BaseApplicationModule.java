package com.wyman.wymanframework.di.testdi;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @author wyman
 * @date 2018/5/18
 * description :
 */
@Module
public class BaseApplicationModule {

    private BaseApplication mBaseApplication;

    public BaseApplicationModule(BaseApplication mBaseApplication) {
        this.mBaseApplication = mBaseApplication;
    }

    @Provides
    BaseApplication provideBaseApplication(){
        return mBaseApplication;
    }

    @Provides
    Context provideContext(){
        return mBaseApplication.getApplicationContext();
    }
}
