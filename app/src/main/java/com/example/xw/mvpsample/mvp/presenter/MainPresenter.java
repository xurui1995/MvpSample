package com.example.xw.mvpsample.mvp.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.xw.mvpsample.bean.User;
import com.example.xw.mvpsample.mvp.model.MainModel;
import com.example.xw.mvpsample.mvp.view.MainView;
import com.example.xw.mvpsample.retrofit.HttpMethods;

import rx.Subscriber;

/**
 * Created by xw on 2016/11/1.
 */
public class MainPresenter implements BasePresenter {
    private MainView mMainView;
    private MainModel mModel;

    public MainPresenter() {
        mModel=new MainModel();
    }

    @Override
    public void attachView(MainView view) {
        mMainView=view;
    }

    @Override
    public void detachView() {
        mMainView=null;
    }
    @Override
    public void searchUser(String loginName) {
        if(TextUtils.isEmpty(loginName.trim())){
            mMainView.showErrorMessage("请输入合法登录名");
            return;
        }
        if (mModel!=null){
            mModel.getUser(new Subscriber<User>() {
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
                    mMainView.showErrorMessage("搜索失败");
                }

                @Override
                public void onNext(User user) {
                    mMainView.showText(user);
                }
            },loginName);
        }

    }
}
