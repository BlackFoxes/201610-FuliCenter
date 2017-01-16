package ucai.cn.fulicenter.application;

import android.app.Application;
import android.content.Context;

import ucai.cn.fulicenter.controller.activity.MainActivity;

/**
 * Created by BlackFox on 2017/1/10.
 */
public  class FuLiCenterApplication extends Application {
    private static Context instance;

    public FuLiCenterApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=getApplicationContext();
    }

    public static Context getInstance() {
        return instance;

    }

}
