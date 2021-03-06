package com.wyman.wymanframework.base;

import android.content.Context;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author wyman
 * @date 2018/4/11
 * description :
 */

public  class BasePresenter<T extends BaseView> {

    private WeakReference<T> mVReference;
    protected Context mContext;

    protected <V> void invoke(Observable<V> observable, Observer<V> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).compose(getView().<V>bindToLife()).subscribe(observer);
    }

    public BasePresenter(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 关联
     *
     * @param view
     */
    void attachView(T view) {
        mVReference = new WeakReference<T>(view);

    }

    /**
     * 接触关联
     */
    void detachView() {

        if (mVReference != null) {
            mVReference.clear();
            mVReference = null;
        }
    }

    public T getView() {

        return mVReference.get();
    }
}
