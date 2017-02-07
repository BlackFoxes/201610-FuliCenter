package ucai.cn.fulicenter.controller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ucai.cn.fulicenter.R;
import ucai.cn.fulicenter.controller.fragment.NewGoodFragment;

public class BoutiqueChildActivity extends AppCompatActivity {
    TextView tvTitle;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique_child);
        initView();
        initData();
        setListener();

    }

    private void setListener() {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        NewGoodFragment boutiqueChild = new NewGoodFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutChild,boutiqueChild).commit();
        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);

    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tvBackTitle);
        view = findViewById(R.id.bcLayout);



    }
}
