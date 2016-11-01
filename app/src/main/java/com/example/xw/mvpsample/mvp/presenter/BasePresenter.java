package com.example.xw.mvpsample.mvp.presenter;

import com.example.xw.mvpsample.mvp.view.BaseView;

/**
 * Created by xw on 2016/11/1.
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
    void searchUser(String loginName);
}
