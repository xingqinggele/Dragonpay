package com.example.dragonpay.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.dragonpay.presenter.BasePresenter;
import com.example.dragonpay.view.IBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2022/6/7
 * 描述:MVP架构基层Fragment
 */
public abstract class BaseFragment<T extends BasePresenter, V extends IBaseView> extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    protected T presenter;
    public static List<Activity> activitys;
    protected Context mContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mContext = getActivity();
        //选择自己的表示层
        presenter = createPresenter();
        presenter.attachView((V) this);
        if (activitys == null) {
            activitys = new ArrayList<Activity>();
        }
        activitys.add(getActivity());

        //初始化
        init(view);
        return view;
    }

    protected abstract void init(View view);

    protected abstract T createPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.deatchView();
    }


}