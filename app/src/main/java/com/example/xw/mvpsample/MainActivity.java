package com.example.xw.mvpsample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xw.mvpsample.bean.User;
import com.example.xw.mvpsample.mvp.presenter.MainPresenter;
import com.example.xw.mvpsample.mvp.view.MainView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    @InjectView(R.id.tv)
    TextView mTextView;
    @InjectView(R.id.search_btn)
    Button mButton;
    @InjectView(R.id.ed_text)
    EditText mEditText;

    private  ProgressDialog dialog;
    private MainPresenter mMainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();
        mMainPresenter=new MainPresenter();
        mMainPresenter.attachView(this);
    }

    /**
     * 一些初始化，这里为ProgressDialog的初始化
     */
    private void initView() {
        dialog=new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在搜索中");
    }

    @OnClick(R.id.search_btn)
    void search(View view){

    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void showText(User userbean) {
        String temp=getResources().getString(R.string.user_format);
        String str=String.format(temp,userbean.getLogin(),userbean.getName(),userbean.getFollowers(),userbean.getFollowing());
        mTextView.setText(str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mMainPresenter!=null)
        mMainPresenter.detachView();
    }
}
