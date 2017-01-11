package ucai.cn.fulicenter.controller.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ucai.cn.fulicenter.R;
import ucai.cn.fulicenter.view.MFGT;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MFGT.close(SplashActivity.this);
                MFGT.startActivity(SplashActivity.this,new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 2000);

    }
}
