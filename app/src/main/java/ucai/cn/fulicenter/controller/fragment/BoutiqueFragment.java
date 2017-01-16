package ucai.cn.fulicenter.controller.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ucai.cn.fulicenter.R;
import ucai.cn.fulicenter.application.I;
import ucai.cn.fulicenter.controller.adapter.BoutiqueAdapter;
import ucai.cn.fulicenter.model.bean.BoutiqueBean;
import ucai.cn.fulicenter.utils.ConvertUtils;
import ucai.cn.fulicenter.utils.OkHttpUtils;
import ucai.cn.fulicenter.view.holders.Decoration;

public class BoutiqueFragment extends Fragment {


    Context mContext;

    public BoutiqueFragment() {
    }
    LinearLayoutManager mLinearLayoutManager;
    BoutiqueAdapter boutiqueAdapter;
    ArrayList<BoutiqueBean> mBoutiques;
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    TextView mRefresh;
    View inflate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        inflate = LayoutInflater.from(mContext).inflate(R.layout.fragment_boutique, container, false);
        initView();
        initData();
        initListenter();
        return inflate;
    }

    private void initView() {
        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.boutiqueRec);
        mSwipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.boutiqueSwip);
        mRefresh = (TextView) inflate.findViewById(R.id.boutiquetv);
    }

    private void initData() {
        mBoutiques = new ArrayList<>();
        boutiqueAdapter = new BoutiqueAdapter(mBoutiques, mContext);
        downloadData();
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setAdapter(boutiqueAdapter);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(new Decoration(10,1));
    }

    private void initListenter() {
        setPullDownListener();
    }

    private void setPullDownListener() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                mRefresh.setVisibility(View.VISIBLE);
                downloadData();

            }
        });
    }

    private void downloadData() {
        OkHttpUtils<BoutiqueBean[]> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(I.REQUEST_FIND_BOUTIQUES)
                .targetClass(BoutiqueBean[].class)
                .execute(new OkHttpUtils.OnCompleteListener<BoutiqueBean[]>() {
                    @Override
                    public void onSuccess(BoutiqueBean[] result) {
                        if (result != null && result.length != 0) {
                            Log.e("BoutiqueFragment", "result.length=" + result.length);
                            ArrayList<BoutiqueBean> mList = ConvertUtils.array2List(result);
                            boutiqueAdapter.initData(mList);
                            mSwipeRefreshLayout.setRefreshing(false);
                            mRefresh.setVisibility(View.GONE);

                        }
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("BoutiqueFragment", "errorh=" + error);
                        mSwipeRefreshLayout.setRefreshing(false);
                        mRefresh.setVisibility(View.GONE);


                    }
                });


    }
}
