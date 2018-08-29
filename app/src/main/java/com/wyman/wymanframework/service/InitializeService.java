package com.wyman.wymanframework.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.wyman.wymanframework.BuildConfig;
import com.wyman.wymanframework.base.App;

import me.yokeyword.fragmentation.Fragmentation;


/**
 * @author wyman
 * @date 2018/3/16
 * description :
 */

public class InitializeService extends IntentService {

    private static final String ACTION_INIT_WHEN_APP_CREATE = "com.zyjr.emergencylending.service.action.INIT";
    public static StringBuilder cacheMsg = new StringBuilder();
    public static MsgDisplayListener msgDisplayListener;

    public interface MsgDisplayListener {
        void handle(String msg);
    }

    //第三方分享配置
    {
//        PlatformConfig.setWeixin("wx14758d54ffd39c18", "2f5a5462b73e1952ae9121b125e050cd");
//        PlatformConfig.setQQZone("1105705046", "mh4btC2fYzyHJsyo");
//        PlatformConfig.setSinaWeibo("634140413", "49cfa168cc7892724dda804a642b3ce0", "http://sns.whalecloud.ckeom");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public InitializeService() {
        super("InitializeService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_INIT_WHEN_APP_CREATE.equals(action)) {
                performInit();
            }
        }


    }

    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
    }

    private void performInit() {
        initFragmentation();
        initARouter();
        initUtils();
    }

    private void initFragmentation() {
        Fragmentation.builder().stackViewMode(Fragmentation.BUBBLE).debug(true).install();
    }



    private void initUtils() {
        Utils.init(App.getInstance());

    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(App.getInstance()); // 尽可能早，推荐在Application中初始化
    }
}
