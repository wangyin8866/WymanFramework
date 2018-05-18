package com.wyman.wymanframework;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.wyman.wymanframework.base.BaseActivity;
import com.wyman.wymanframework.ui.home.HomeFragment;
import com.wyman.wymanframework.ui.invest.InvestFragment;
import com.wyman.wymanframework.ui.my.MyFragment;
import com.wyman.wymanframework.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;

@Route(path = "/app/MainActivity")
public class MainActivity extends BaseActivity {
    @BindView(R.id.id_tab_iv_01)
    ImageView idTabIv01;
    @BindView(R.id.id_tab_tv_01)
    TextView idTabTv01;
    @BindView(R.id.id_tab_ll_01)
    LinearLayout idTabLl01;
    @BindView(R.id.id_tab_iv_02)
    ImageView idTabIv02;
    @BindView(R.id.id_tab_tv_02)
    TextView idTabTv02;
    @BindView(R.id.id_tab_ll_02)
    LinearLayout idTabLl02;
    @BindView(R.id.id_tab_iv_03)
    ImageView idTabIv03;
    @BindView(R.id.id_tab_tv_03)
    TextView idTabTv03;
    @BindView(R.id.id_tab_ll_03)
    LinearLayout idTabLl03;
    @BindView(R.id.id_tab_iv_04)
    ImageView idTabIv04;
    @BindView(R.id.id_tab_tv_04)
    TextView idTabTv04;
    @BindView(R.id.id_tab_ll_04)
    LinearLayout idTabLl04;
    private ISupportFragment[] mFragments = new ISupportFragment[4];
    private long mExitTime;
    public static int currentPage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {
    }


    @Override
    protected void initView() {




        ISupportFragment homeFragment = findFragment(HomeFragment.class);
        if (homeFragment == null) {
            mFragments[0] = HomeFragment.newInstance();
            mFragments[1] = InvestFragment.newInstance();
            mFragments[2] = MyFragment.newInstance();
            mFragments[3] = InvestFragment.newInstance();
            loadMultipleRootFragment(R.id.layout_fragment, currentPage,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3]);

        } else {
            // 这里我们需要拿到mFragments的引用
            mFragments[0] = homeFragment;
            mFragments[1] = findFragment(InvestFragment.class);
            mFragments[2] = findFragment(MyFragment.class);
            mFragments[3] = findFragment(InvestFragment.class);
        }
        setTabSelection(currentPage);
    }


    public void setTabSelection(int currentPage) {
        //选中前清除状态
        restView();
        switch (currentPage) {
            case 0://未登录
                idTabIv01.setImageResource(R.mipmap.ic_home_checked);
                idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                break;
            case 1:
                idTabIv02.setImageResource(R.mipmap.ic_product_checked);
                idTabTv02.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                break;
            case 2:
                idTabIv03.setImageResource(R.mipmap.ic_baina_checked);
                idTabTv03.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                break;
            case 3:
                idTabIv04.setImageResource(R.mipmap.ic_my_checked);
                idTabTv04.setTextColor(getResources().getColor(R.color.tv_navigate_checked));
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShort("再按一次退出程序");
                mExitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @OnClick({R.id.id_tab_ll_01, R.id.id_tab_ll_02, R.id.id_tab_ll_03, R.id.id_tab_ll_04})
    public void onViewClicked(View view) {
        restView();
        switch (view.getId()) {
            case R.id.id_tab_ll_01:
                showHideFragment(mFragments[0], mFragments[currentPage]);
                currentPage = 0;

                break;
            case R.id.id_tab_ll_02:
                showHideFragment(mFragments[1], mFragments[currentPage]);
                currentPage = 1;
                break;
            case R.id.id_tab_ll_03:
                showHideFragment(mFragments[2], mFragments[currentPage]);
                currentPage = 2;
                break;
            case R.id.id_tab_ll_04:
                showHideFragment(mFragments[3], mFragments[currentPage]);
                currentPage = 3;
                break;
        }
        setTabSelection(currentPage);
    }

    /**
     * 重置所有状态
     */
    private void restView() {
        idTabIv01.setImageResource(R.mipmap.ic_home);
        idTabIv02.setImageResource(R.mipmap.ic_product);
        idTabIv03.setImageResource(R.mipmap.ic_baina);
        idTabIv04.setImageResource(R.mipmap.ic_my);
        idTabTv01.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv02.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv03.setTextColor(getResources().getColor(R.color.tv_navigate));
        idTabTv04.setTextColor(getResources().getColor(R.color.tv_navigate));

    }
}
