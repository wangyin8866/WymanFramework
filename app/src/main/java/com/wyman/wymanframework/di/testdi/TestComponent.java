package com.wyman.wymanframework.di.testdi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@Singleton
@Component(dependencies = BaseApplicationComponent.class,modules = {TeacherModule.class,StudenModule.class})
public interface TestComponent {

    void inject(TestActivity testActivity);
}
