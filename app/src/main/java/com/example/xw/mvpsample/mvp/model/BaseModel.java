package com.example.xw.mvpsample.mvp.model;

import com.example.xw.mvpsample.bean.User;

/**
 * Created by xw on 2016/11/1.
 */
public interface BaseModel {
    User getUser(String loginName);

}
