package com.example.xw.mvpsample.mvp.presenter;

import com.example.xw.mvpsample.mvp.view.MainView;

/**
 * Created by xw on 2016/11/1.
 */
public class MainPresenter implements BasePresenter {
    private MainView mMainView;
    @Override
    public void attachView(MainView view) {
        mMainView=view;
    }

    @Override
    public void detachView() {
        mMainView=null;
    }

    @Override
    public void searchUser() {

    }
}
