package ucai.cn.fulicenter.controller.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import ucai.cn.fulicenter.R;
import ucai.cn.fulicenter.controller.fragment.NewGoodFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton[] mRadioButtons;
    FragmentTransaction transaction;
    NewGoodFragment newGoodFragment;
    int currentIndex, index;
    @BindView(R.id.layout_newgoods)
    RadioButton layoutNewgoods;
    @BindView(R.id.layout_boutique)
    RadioButton layoutBoutique;
    @BindView(R.id.layout_categories)
    RadioButton layoutCategories;
    @BindView(R.id.layout_cart)
    RadioButton layoutCart;
    @BindView(R.id.layout_self)
    RadioButton layoutSelf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        newGoodFragment = new NewGoodFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        mRadioButtons = new RadioButton[]{layoutNewgoods,layoutBoutique,layoutCategories,
                layoutCart,layoutSelf};
        for (int i = 0; i < mRadioButtons.length; i++) {
            mRadioButtons[i].setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_newgoods:
                index = 0;
                transaction.replace(R.id.mFrame,newGoodFragment).commit();
                break;
            case R.id.layout_boutique:
                index = 1;
                break;
            case R.id.layout_categories:
                index = 2;
                break;
            case R.id.layout_cart:
                index = 3;

                break;
            case R.id.layout_self:
                index = 4;
                break;
        }
        Log.e("main", "index=" + index);
        if (index != currentIndex) {

            checkButton();

        }
    }

    private void checkButton() {
        for (int i = 0; i < mRadioButtons.length; i++) {
            if (index != i) {
                mRadioButtons[i].setChecked(false);
            } else {
                mRadioButtons[i].setChecked(true);
            }
        }
        currentIndex = index;
    }


}
