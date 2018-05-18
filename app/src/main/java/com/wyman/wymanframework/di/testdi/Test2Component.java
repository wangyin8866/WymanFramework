package com.wyman.wymanframework.di.testdi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@Singleton
@Component(modules = StudenModule.class)
public interface Test2Component {

    void inject(Test2Activity testActivity);
}
