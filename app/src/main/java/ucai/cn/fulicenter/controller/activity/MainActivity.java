package ucai.cn.fulicenter.controller.activity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import ucai.cn.fulicenter.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RadioButton[] mRadioButtons;
    int currentIndex,index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioButtons = new RadioButton[5];
        mRadioButtons[0] = (RadioButton) findViewById(R.id.layout_newgoods);
        mRadioButtons[1] = (RadioButton) findViewById(R.id.layout_boutique);
        mRadioButtons[2] = (RadioButton) findViewById(R.id.layout_categories);
        mRadioButtons[3] = (RadioButton) findViewById(R.id.layout_cart);
        mRadioButtons[4] = (RadioButton) findViewById(R.id.layout_self);
        for (int i=0;i<mRadioButtons.length;i++) {
            mRadioButtons[i].setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_newgoods:
                index=0;
                break;
            case R.id.layout_boutique:
                index=1;
                break;
            case R.id.layout_categories:
                index=2;
                break;
            case R.id.layout_cart:
                index=3;

                break;
            case R.id.layout_self:
                index=4;
                break;
        }
        Log.e("main", "index=" + index);
        if (index!=currentIndex) {

            checkButton();

        }
    }
    private void checkButton() {
        for (int i=0;i<mRadioButtons.length;i++) {
            if (index != i) {
                mRadioButtons[i].setChecked(false);
            } else {
                mRadioButtons[i].setChecked(true);
            }
        }
        currentIndex = index;
    }
}
