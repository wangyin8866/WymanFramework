package com.wyman.wymanframework.di.component;

import android.app.Activity;
import android.content.Context;

import com.wyman.wymanframework.di.module.ActivityModule;
import com.wyman.wymanframework.di.scope.ContextLife;
import com.wyman.wymanframework.di.scope.PerActivity;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = {ActivityModule.class})
public interface ActivityComponent {


    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

}
