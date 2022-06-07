package com.example.dragonpay.presenter;


import com.example.dragonpay.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:
 */
public class BasePresenter<T extends IBaseView> {

    //弱引用
    public WeakReference<T> iGoodsView;

    /**
     * 弱引用
     * 手动绑定
     */
    public void attachView(T view) {
        iGoodsView = new WeakReference<>(view);
    }

    /**
     * 弱引用
     * 手动解除绑定
     */
    public void deatchView() {
        if (iGoodsView != null) {
            iGoodsView.clear();
            iGoodsView = null;
        }
    }
} 