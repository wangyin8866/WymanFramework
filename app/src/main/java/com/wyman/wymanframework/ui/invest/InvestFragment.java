package com.wyman.wymanframework.ui.invest;

import android.view.View;

import com.wyman.wymanframework.R;
import com.wyman.wymanframework.base.BaseFragment;

/**
 * @author wyman
 * @date 2018/4/13
 * description :
 */

public class InvestFragment extends BaseFragment {

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_invest_main;
    }

    @Override
    protected void initInjector() {

    }


    public static InvestFragment newInstance() {
        return new InvestFragment();
    }
}
