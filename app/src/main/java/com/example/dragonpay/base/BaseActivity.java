package com.example.dragonpay.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.dragonpay.presenter.BasePresenter;
import com.example.dragonpay.util.SPUtils;
import com.example.dragonpay.view.IBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2022/6/7
 * 描述:MVP架构基层Activity
 */
public abstract class BaseActivity<T extends BasePresenter, V extends IBaseView> extends AppCompatActivity {
    protected T presenter;
    protected Context mContext;
    public static List<Activity> activitys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;
        //选择自己的表示层
        presenter = createPresenter();
        presenter.attachView((V) this);
        if (activitys == null) {
            activitys = new ArrayList<Activity>();
        }
        activitys.add(this);
        //初始化
        init();
        //触发事件
        initListener();
    }



    protected abstract T createPresenter();

    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract void initListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatchView();
    }

}