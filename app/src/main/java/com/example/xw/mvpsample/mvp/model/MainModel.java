package com.example.xw.mvpsample.mvp.model;

import com.example.xw.mvpsample.bean.User;
import com.example.xw.mvpsample.retrofit.HttpMethods;

import rx.Subscriber;

/**
 * Created by xw on 2016/11/1.
 */
public class MainModel implements BaseModel{
    @Override
    public void getUser(Subscriber<User> subscriber ,String loginName) {
        HttpMethods.getInstance().getUser(subscriber,loginName);
    }
}
