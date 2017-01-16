package ucai.cn.fulicenter.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ucai.cn.fulicenter.R;

/**
 * Created by BlackFox on 2017/1/11.
 */

public class BoutiqueHolder extends RecyclerView.ViewHolder{

    public TextView mDesc;
    public TextView mTitle;
    public TextView mName;
    public ImageView mPic;

    public BoutiqueHolder(View itemView) {
        super(itemView);
        mDesc = (TextView) itemView.findViewById(R.id.boutiqueDsc);
        mTitle = (TextView) itemView.findViewById(R.id.boutiqueTitle);
        mName = (TextView) itemView.findViewById(R.id.boutiqueName);
        mPic = (ImageView) itemView.findViewById(R.id.ivBoutique);

    }
}
