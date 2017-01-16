package ucai.cn.fulicenter.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ucai.cn.fulicenter.R;

/**
 * Created by BlackFox on 2017/1/11.
 */

public class NewGoodsHolder extends RecyclerView.ViewHolder{

    public TextView mPrice;
    public TextView mTitle;
    public ImageView mPic;

    public NewGoodsHolder(View itemView) {
        super(itemView);
        mPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        mTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        mPic = (ImageView) itemView.findViewById(R.id.ivNewGoods);

    }
}
