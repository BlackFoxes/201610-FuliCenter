package ucai.cn.fulicenter.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ucai.cn.fulicenter.R;
import ucai.cn.fulicenter.application.I;
import ucai.cn.fulicenter.model.bean.BoutiqueBean;
import ucai.cn.fulicenter.model.bean.NewGoodsBean;
import ucai.cn.fulicenter.utils.ImageLoader;
import ucai.cn.fulicenter.view.holders.BoutiqueHolder;
import ucai.cn.fulicenter.view.holders.FooterHolder;
import ucai.cn.fulicenter.view.holders.NewGoodsHolder;

/**
 * Created by BlackFox on 2017/1/11.
 */
public class BoutiqueAdapter extends RecyclerView.Adapter{
    ArrayList<BoutiqueBean> mList;
    Context context;
    public BoutiqueAdapter(ArrayList<BoutiqueBean> list, Context context) {
        this.mList = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.boutique_item, null);
            return new BoutiqueHolder(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            BoutiqueBean boutiqueBean = mList.get(position);
//            Log.e("GoodsAdapter", "goodsBean=" + goodsBean.toString());
            ((BoutiqueHolder) holder).mDesc.setText(boutiqueBean.getDescription());
            ((BoutiqueHolder) holder).mTitle.setText(boutiqueBean.getTitle());
            ((BoutiqueHolder) holder).mName.setText(boutiqueBean.getName());
            ImageLoader.build(I.DOWNLOAD_IMG_URL +boutiqueBean.getImageurl())
                    .defaultPicture(R.drawable.nopic)
                    .imageView(((BoutiqueHolder) holder).mPic)
                    .showImage(context);

    }

    @Override
    public int getItemCount() {
        return mList.size()==0?0:mList.size();
    }

    public void initData(ArrayList<BoutiqueBean> arrayList1) {
        if (mList != null) {
            mList.clear();
        }
        addData(arrayList1);
    }

    public void addData(ArrayList<BoutiqueBean> arrayList2) {
        if (arrayList2 != null && arrayList2.size() != 0) {

            mList.addAll(arrayList2);
        }
        notifyDataSetChanged();



    }




}
