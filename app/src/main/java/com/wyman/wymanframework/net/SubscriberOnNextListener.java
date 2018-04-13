package com.wyman.wymanframework.net;

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onError(Throwable e);

}