package com.example.xw.mvpsample.mvp.presenter;

import android.widget.Toast;

import com.example.xw.mvpsample.bean.User;
import com.example.xw.mvpsample.mvp.view.MainView;
import com.example.xw.mvpsample.retrofit.HttpMethods;

import rx.Subscriber;

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
        HttpMethods.getInstance().getUser(new Subscriber<User>() {
            @Override
            public void onStart() {
                mMainView.showProgressDialog();
            }

            @Override
            public void onCompleted() {
                mMainView.hideProgressDialog();

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {
                mMainView.showText(user);
            }
        },"xurui");
    }
}
