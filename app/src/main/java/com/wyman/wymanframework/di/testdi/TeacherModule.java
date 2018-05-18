package com.wyman.wymanframework.di.testdi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author wyman
 * @date 2018/5/17
 * description :
 */
@Module
public class TeacherModule {

    @Singleton
    @Provides
    public Teacher provideStudent() {
        return new Teacher();
    }
}
