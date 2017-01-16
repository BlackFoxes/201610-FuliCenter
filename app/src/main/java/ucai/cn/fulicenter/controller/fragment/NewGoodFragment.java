package ucai.cn.fulicenter.controller.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ucai.cn.fulicenter.R;
import ucai.cn.fulicenter.application.I;
import ucai.cn.fulicenter.controller.adapter.GoodsAdapter;
import ucai.cn.fulicenter.model.bean.NewGoodsBean;
import ucai.cn.fulicenter.utils.ConvertUtils;
import ucai.cn.fulicenter.utils.OkHttpUtils;
import ucai.cn.fulicenter.view.holders.Decoration;


public class NewGoodFragment extends Fragment {


    GridLayoutManager mGridLayoutManager;
    GoodsAdapter mAdapter;
    Context context;
    private static int ACTION_PULL_DOWN = 1;
    private static int ACTION_PULL_UP = 2;
    private static int ACTION_DOWNLOAD = 0;
    int pageId;
    ArrayList<NewGoodsBean> mArraylist;
    @BindView(R.id.tvRefresh)
    TextView tvRefresh;
    @BindView(R.id.rvRefresh)
    RecyclerView rvRefresh;
    @BindView(R.id.swRefresh)
    SwipeRefreshLayout swRefresh;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_good, container, false);
        context = getContext();
        ButterKnife.bind(this, view);
        initData();
        setListener();
        return view;
    }

    private void setListener() {
        setPullUpListener();
        setPullDownListener();
    }

    private void setPullDownListener() {
        swRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageId = 1;
                tvRefresh.setVisibility(View.VISIBLE);
                downloadData(ACTION_PULL_DOWN,pageId);

            }
        });


    }
    private void setPullUpListener() {
        rvRefresh.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastPosition;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE &&
                        lastPosition+1==mAdapter.getItemCount()
                       ) {
                    pageId++;
                    downloadData(ACTION_PULL_UP,pageId);
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastPosition = mGridLayoutManager.findLastVisibleItemPosition();
            }
        });
    }
    private void initData() {
//        Log.e("NewGoodFragment", "start");
        mArraylist = new ArrayList<>();
        mAdapter = new GoodsAdapter(mArraylist, context);
//        Log.e("NewGoodFragment", "mAdapter.getCount=" + mAdapter.getItemCount());
        pageId = 1;
        downloadData(ACTION_DOWNLOAD,pageId);
        mGridLayoutManager = new GridLayoutManager(context, 2);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rvRefresh.setLayoutManager(mGridLayoutManager);
        rvRefresh.setAdapter(mAdapter);
        rvRefresh.addItemDecoration(new Decoration(10));
    }
    private void downloadData(final int action, int
                              pageId) {
        OkHttpUtils<NewGoodsBean[]> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_FIND_NEW_BOUTIQUE_GOODS)
                .addParam(I.CAT_ID,"0")
                .addParam(I.PAGE_ID, String.valueOf(pageId))
                .addParam(I.PAGE_SIZE,"10")
                .targetClass(NewGoodsBean[].class)
                .execute(new OkHttpUtils.OnCompleteListener<NewGoodsBean[]>() {
                    @Override
                    public void onSuccess(NewGoodsBean[] result) {
                        ArrayList<NewGoodsBean> list = null;
                        if (result != null&&result.length!=0) {
                            mAdapter.setMore(true);
                            list = ConvertUtils.array2List(result);
                            mAdapter.setFooterShow("加载更多数据");
                        } else {
                            mAdapter.setMore(false);
                            mAdapter.setFooterShow("没有更多数据");
                        }
                        switch (action) {
                            case I.ACTION_DOWNLOAD:
                                mAdapter.initData(list);
                                break;
                            case I.ACTION_PULL_UP:
                                mAdapter.addData(list);
                                break;
                            case I.ACTION_PULL_DOWN:
                                tvRefresh.setVisibility(View.GONE);
                                swRefresh.setRefreshing(false);
                                mAdapter.initData(list);
                                break;
                        }
                    }
                    @Override
                    public void onError(String error) {
                        Log.e("NewGoodFragment", "error=" + error);
                    }
                });



    }


}
