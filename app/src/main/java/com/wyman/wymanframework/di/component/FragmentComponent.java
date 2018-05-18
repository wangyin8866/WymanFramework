package com.wyman.wymanframework.di.component;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.wyman.wymanframework.di.module.FragmentModule;
import com.wyman.wymanframework.di.module.PresenterModule;
import com.wyman.wymanframework.di.scope.ContextLife;
import com.wyman.wymanframework.di.scope.PerFragment;
import com.wyman.wymanframework.ui.home.HomeFragment;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class,modules = {FragmentModule.class, PresenterModule.class})
public interface FragmentComponent {
    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();


    Fragment getFragment();
    Activity getActivity();

    void inject(HomeFragment homeFragment);
}
