package com.wyman.wymanframework.di.testdi;

import android.content.Context;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/18
 * description :
 */
@Component(modules = BaseApplicationModule.class)

public interface BaseApplicationComponent {
    BaseApplication BASE_APPLICATION();

    Context baseContext();
}
