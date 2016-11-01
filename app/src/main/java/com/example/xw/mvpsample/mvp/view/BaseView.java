package com.example.xw.mvpsample.mvp.view;

import com.example.xw.mvpsample.bean.User;

/**
 * Created by xw on 2016/11/1.
 */
public interface BaseView {
    void showProgressDialog();
    void hideProgressDialog();
    void showText(User userbean);
    void showErrorMessage(String text);
}
