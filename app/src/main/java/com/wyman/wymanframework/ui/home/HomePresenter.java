package com.wyman.wymanframework.ui.home;

import android.content.Context;

import com.wyman.wymanframework.base.BasePresenter;
import com.wyman.wymanframework.base.RetrofitManager;
import com.wyman.wymanframework.entity.Banner;
import com.wyman.wymanframework.entity.DataResponse;
import com.wyman.wymanframework.net.ApiService;
import com.wyman.wymanframework.net.ProgressObserver;
import com.wyman.wymanframework.net.SubscriberOnNextListener;

import java.util.List;

/**
 * @author wyman
 * @date 2018/4/12
 * description :
 */

public class HomePresenter extends BasePresenter<HomeView> {

    public HomePresenter(Context mContext) {
        super(mContext);
    }

    public void fetch() {
        invoke(RetrofitManager.create(ApiService.class).getHomeBanners(), new ProgressObserver<DataResponse<List<Banner>>>(new SubscriberOnNextListener<DataResponse<List<Banner>>>() {
            @Override
            public void onNext(DataResponse<List<Banner>> listDataResponse) {

                getView().showDate(listDataResponse.toString());
            }

            @Override
            public void onError(Throwable e) {

            }
        }, mContext));

    }
}
