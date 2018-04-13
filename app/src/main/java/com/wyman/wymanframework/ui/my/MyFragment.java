package com.wyman.wymanframework.ui.my;

import android.view.View;

import com.wyman.wymanframework.R;
import com.wyman.wymanframework.base.BaseFragment;
import com.wyman.wymanframework.base.BasePresenter;
import com.wyman.wymanframework.ui.invest.InvestFragment;

/**
 * @author wyman
 * @date 2018/4/13
 * description :
 */

public class MyFragment extends BaseFragment {

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
    public static MyFragment newInstance() {
        return new MyFragment();
    }
}
