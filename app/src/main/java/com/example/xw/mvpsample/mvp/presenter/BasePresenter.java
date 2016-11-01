package com.example.xw.mvpsample.mvp.presenter;

import android.app.SearchableInfo;

import com.example.xw.mvpsample.mvp.view.MainView;

/**
 * Created by xw on 2016/11/1.
 */
public interface BasePresenter<T extends MainView> {
    void attachView(T view);
    void detachView();
    void searchUser();
}
