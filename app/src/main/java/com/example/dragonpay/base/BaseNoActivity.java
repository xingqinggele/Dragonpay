package com.example.dragonpay.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者: qgl
 * 创建日期：2022/6/7
 * 描述:纯净版基层Activity
 */
public abstract class BaseNoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //初始化
        init();
        //触发事件
        initListener();
    }


    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract void initListener();


}