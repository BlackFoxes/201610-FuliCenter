package ucai.cn.fulicenter.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ucai.cn.fulicenter.R;

/**
 * Created by BlackFox on 2017/1/11.
 */

public class FooterHolder extends RecyclerView.ViewHolder {
    public TextView tvFooter;

    public FooterHolder(View itemView) {
        super(itemView);
        tvFooter = (TextView) itemView.findViewById(R.id.tvFooter);

    }
}
