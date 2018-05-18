package com.wyman.wymanframework.di.component;

import android.content.Context;

import com.wyman.wymanframework.di.module.ApplicationModule;
import com.wyman.wymanframework.di.scope.ContextLife;
import com.wyman.wymanframework.di.scope.PerApp;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/16
 * description :
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife
    Context getApplicationContext();
}
