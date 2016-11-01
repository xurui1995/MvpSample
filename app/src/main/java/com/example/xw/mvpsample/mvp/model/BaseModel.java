package com.example.xw.mvpsample.mvp.model;

import com.example.xw.mvpsample.bean.User;

import rx.Subscriber;

/**
 * Created by xw on 2016/11/1.
 */
public interface BaseModel {
    void getUser(Subscriber<User> subscribe,String loginName);

}
