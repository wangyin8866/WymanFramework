package com.wyman.wymanframework.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wyman.wymanframework.R;
import com.wyman.wymanframework.base.BaseFragment;
import com.wyman.wymanframework.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wyman
 * @date 2018/4/13
 * description :
 */

public class HomeFragment extends BaseFragment {

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
