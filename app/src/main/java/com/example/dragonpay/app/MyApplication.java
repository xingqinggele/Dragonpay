package com.example.dragonpay.app;

import android.app.Application;
import android.content.Context;


/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:
 */
public class MyApplication extends Application {
    public static Context context;
    private static MyApplication allApp;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        allApp = this;
    }

    /**
     * 获得上下文的全局对象
     *
     * @return 全局app
     */
    public static MyApplication getApp() {
        return allApp;
    }



}