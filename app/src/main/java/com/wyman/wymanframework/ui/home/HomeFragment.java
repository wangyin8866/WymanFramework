package com.wyman.wymanframework.ui.home;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.wyman.wymanframework.R;
import com.wyman.wymanframework.base.BaseFragment;
import com.wyman.wymanframework.utils.LogUtils;

import static android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
import static android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
import static android.view.WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER;

/**
 * @author wyman
 * @date 2018/4/13
 * description : 测试悬浮窗
 */

public class HomeFragment extends BaseFragment<HomePresenter, HomeView> {
    private WindowManager mWm;
    private WindowManager.LayoutParams params;
    private LinearLayout linearLayout;

    @Override
    protected void initView(View view) {
        LogUtils.e("wyman", mPresenter.toString());
        initWindDialog();
    }

    @Override
    public void onResume() {
        super.onResume();
        mWm.addView(linearLayout, params);
    }

    @Override
    public void onPause() {
        super.onPause();
        mWm.removeView(linearLayout);
    }

    @Override

    public void onHiddenChanged(boolean hidden) {

        if (hidden) {

            //相当于Fragment的onPause()
            mWm.removeView(linearLayout);
        } else {

            // 相当于Fragment的onResume()
            mWm.addView(linearLayout, params);
        }

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

    private void initWindDialog() {
        mWm = (WindowManager) mFragmentComponent.getActivity().getSystemService(Context.WINDOW_SERVICE);
        params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSPARENT);
        LayoutInflater inflater = LayoutInflater.from(mFragmentComponent.getActivity());
        linearLayout = (LinearLayout) inflater.inflate(R.layout.home_window_dialog, null);

        params.gravity = FLAG_NOT_TOUCH_MODAL | FLAG_NOT_FOCUSABLE | FLAG_SHOW_WALLPAPER;
        params.flags = FLAG_NOT_FOCUSABLE;
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        params.x = 0;
        params.y = 0;

    }
}
