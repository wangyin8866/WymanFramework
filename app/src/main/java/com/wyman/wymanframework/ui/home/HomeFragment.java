package com.wyman.wymanframework.ui.home;

import android.view.View;

import com.wyman.wymanframework.R;
import com.wyman.wymanframework.base.BaseFragment;
import com.wyman.wymanframework.utils.LogUtils;

/**
 * @author wyman
 * @date 2018/4/13
 * description :
 */

public class HomeFragment extends BaseFragment<HomePresenter,HomeView> {

    @Override
    protected void initView(View view) {
        LogUtils.e("wyman", mPresenter.toString());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_main;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
