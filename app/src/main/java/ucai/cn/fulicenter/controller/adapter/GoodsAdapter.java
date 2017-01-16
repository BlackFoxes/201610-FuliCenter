package ucai.cn.fulicenter.controller.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.Inflater;

import ucai.cn.fulicenter.R;
import ucai.cn.fulicenter.application.I;
import ucai.cn.fulicenter.model.bean.NewGoodsBean;
import ucai.cn.fulicenter.utils.ImageLoader;
import ucai.cn.fulicenter.view.holders.FooterHolder;
import ucai.cn.fulicenter.view.holders.NewGoodsHolder;

/**
 * Created by BlackFox on 2017/1/11.
 */
public class GoodsAdapter extends RecyclerView.Adapter{
    ArrayList<NewGoodsBean> mList;
    Context context;
    private static int NEWGOODS_ITEM_FOOTER = 0;
    private static int NEWGOODS_ITEM = 1;
    String footerShow;
    boolean isMore;

    public void setFooterShow(String footerShow) {
        this.footerShow = footerShow;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public boolean isMore() {
        return isMore;
    }

    public GoodsAdapter(ArrayList<NewGoodsBean> list, Context context) {
        this.mList = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == NEWGOODS_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.new_goods_item, null);
            return new NewGoodsHolder(view);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.layout_footer, null);
        return new FooterHolder(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof NewGoodsHolder) {
            NewGoodsBean goodsBean = mList.get(position);
//            Log.e("GoodsAdapter", "goodsBean=" + goodsBean.toString());
            ((NewGoodsHolder)holder).mPrice.setText(goodsBean.getCurrencyPrice());
            ((NewGoodsHolder)holder).mTitle.setText(goodsBean.getGoodsName());
            ImageLoader.build(I.DOWNLOAD_IMG_URL + goodsBean.getGoodsThumb())
            .defaultPicture(R.drawable.nopic)
            .imageView(((NewGoodsHolder) holder).mPic)
            .showImage(context);

        } else if (holder instanceof FooterHolder) {
            ((FooterHolder)holder).tvFooter.setText(footerShow);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size()==0?0:mList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
//        Log.e("GoodAdapter", "position=" + position);
//        Log.e("GoodAdapter", "getItemCount=" + getItemCount());
        if (position == getItemCount() - 1) {
            return NEWGOODS_ITEM_FOOTER;
        } else {
            return NEWGOODS_ITEM;
        }
    }

    public void initData(ArrayList<NewGoodsBean> arrayList1) {
        if (mList != null) {
            mList.clear();
        }
        addData(arrayList1);
    }

    public void addData(ArrayList<NewGoodsBean> arrayList2) {
        if (arrayList2 != null && arrayList2.size() != 0) {

            mList.addAll(arrayList2);
        }
        notifyDataSetChanged();



    }




}
