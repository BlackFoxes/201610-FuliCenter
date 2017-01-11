package ucai.cn.fulicenter.application;

import android.app.Application;

/**
 * Created by BlackFox on 2017/1/10.
 */
public class FuLiCenterApplication extends Application {
    private static FuLiCenterApplication instance=null;

    public FuLiCenterApplication() {

    }

    public FuLiCenterApplication getInstance() {
        if (instance == null) {
            instance = new FuLiCenterApplication();
        }
        return this.instance;

    }

}
