package com.wyman.wymanframework.base;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.multidex.MultiDex;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import com.wyman.wymanframework.utils.LogUtils;

/**
 * @author wyman
 * @date 2018/7/18
 * description :
 */
public class SophixStubApplication extends SophixApplication {
    private final String TAG = "SophixStubApplication";

    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
    @Keep
    @SophixEntry(App.class)
    static class RealApplicationStub {
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//         如果需要使用MultiDex，需要在此处调用。
        MultiDex.install(this);
        initSophix();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SophixManager.getInstance().queryAndLoadNewPatch();
    }

    private void initSophix() {
        String appVersion = "1.0";
        try {
            appVersion = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0)
                    .versionName;
        } catch (Exception e) {
        }
        final SophixManager instance = SophixManager.getInstance();
        instance.setContext(this)
                .setAppVersion(appVersion)
                .setSecretMetaData("24973836", "7a55bd779433566287d1bada028aa2d6", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCP1A7HDeljJYnVoex3kX8ZBGKCOhxC2bVMIWLMObS/v1LjDxDpd0t2A6bOSGwE9Esl9N/CDLDgZmylHwzbrx8asSz8JDMOZVqGvnBCs9aOZbtCZnAPM8/ETAr7uvXNhQd5whxMBN+crRS7l/8Rts8QBVsxR40pHrU+eb2FUMNSv82OJgiy7et8Onh3rRh6/texdKSMLCLM7jBsLDe8gHDnYTTCzgTp39nCEwN0mhEyVueqgoOYheeS3KTBq1k5j7yAmM66K2Xp9cJxK/MhrKev7ZJhnjG0AbW8dqZcV2G8pw5N8dyUEaGonCJCbu5rFcpyfOYP2OtBd2JmLTovwYCDAgMBAAECggEAeU6mxBaksN3ZWhi/I73Qj94V47Z1XaDXe4VxGcTWAR+yHhX38qGOQNQlnTiR+r+8nh/hlX40tJ9OpRoCM0uJlW63/VXexhaP+rOmZWve261L+l4Bx6CwbOSiItz2MkgwHO6uBSPbIf8NTIePN3aTP/T0jCTIF1VyEmaFhWqvwxr5bn2bPZZz0NvZsbkv9wUJ0ow6vDD5BGeKw8hvtHL2inkgG2JFvR3aI4RO3vxKT0Z2FMOnMUjsBhnZfkrrf672PyRK+MpaGEy5iEoPlcNP9UoaA/jkKUIdqoKN9iM+T2vQ4nP7QqsHmuYhm7u6EWVVanDnLw3S035a8nyZbnbKEQKBgQD6QVKLrcJSEk/qkuyb3RgFxJdXawbkjF9/T6q5eQRUTFpk11wcBbJIeavSSe7Vux4LPBFLMZT/Lvx0PQmIQ5EquFTN/5sC+yKVAzTXiPWtrBX2xqZwbCuGbdyWJdULr5DnRjEbZMe+d6BIDyPRZRvsAard4k/+4vJErQYaJS/2eQKBgQCTIUun1iPVz2tWM/2qC43r1vxMQI/BP88kNrfzkpTJruRl9d+CzyAnYTmrGIumRH2ujUUgBKTYVUAaUuX5BQaYkkjIK3wqlZx+1K1teJZYW7Vpsnj3KocntppugTnzOTWNRrVBl3J8Jd10Rf0gV+5l2FNruHLdVGK7CwFl86kf2wKBgDBEKQeHm9L4dTFo5PmqytdR816I5etup3yGgQcEsDESCN0qLDm7X4da8Ci+2bGfRUwlabB2/6W4CjjhDNWbMoRqyPByPBN3HFRhKe/oGnpElnfiGHfWZQ6oYcMTyONYGTqB7za5WU0DBYbgZKgeOCRsrefdnlAqtU9Jj8O7KGUBAoGBAIjRnZkl+Y0KpbY0At/ufruh4FzIbOY4gFgcylMnLFWg3aQzUPZDxpLYRthkqvijGH0Jwg5UQzcpj8Lq9BDuK4QWBLigN4ciObV38Q6r5KOmJL11yieO1MCJfnLkmQ8lVDdcWZH1U/E/BQDrVMiO/JKY6Hpzu902a9mkEljMjamhAoGBAOjloEccnHGIKDraDvxtUvuEtgFFNix28lWjUVrL9o7tRii6PGvSkGoPLRDKpJ8A2bXYwOi6P0pB1NjYoLC3od0R8susdRBjyliXA58bbRMp7m6vTnzJWoUG+sN96RqujCHm0d40YuJY5acIeBrSrx8tsBGMJJig0lwksxT7+HWX")
                .setEnableDebug(true)
                .setEnableFullLog()
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            LogUtils.e(TAG, "sophix load patch success!");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
                            LogUtils.e(TAG, "sophix preload patch success. restart app to make effect.");
                        }
                    }
                }).initialize();
    }
}
