package ucai.cn.fulicenter.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import ucai.cn.fulicenter.R;

/**
 * Created by BlackFox on 2017/1/10.
 */
public class MFGT {
    public static void close(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
    public static void startActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }
}
