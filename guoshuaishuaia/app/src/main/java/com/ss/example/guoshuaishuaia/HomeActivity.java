package com.ss.example.guoshuaishuaia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ss.example.guoshuaishuaia.adapter.RlvJokeAdapter;
import com.ss.example.guoshuaishuaia.bean.JokeBean;
import com.ss.example.guoshuaishuaia.contract.JokeContract;
import com.ss.example.guoshuaishuaia.presenter.JokePresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements JokeContract.View {

    private Toolbar mToolbar;
    private RecyclerView mRlv;
    private RlvJokeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }
    //获取数据
    private void initData() {
        JokePresenter jokePresenter = new JokePresenter(this);
        jokePresenter.getNetWork();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mToolbar.setTitle("主页");
        setSupportActionBar(mToolbar);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RlvJokeAdapter(this);
        mRlv.setAdapter(mAdapter);
        mAdapter.setonItemClick(new RlvJokeAdapter.onItemClick() {
            @Override
            public void onItem(List<JokeBean.ResultBean> list,int position) {
                OnEventBus onEventBus = new OnEventBus();
                onEventBus.mResultBeans=list;
                onEventBus.position=position;
                EventBus.getDefault().postSticky(onEventBus);
                Intent intent = new Intent(HomeActivity.this, VpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(List<JokeBean.ResultBean> resultBeans) {
        Log.d(TAG, "onSuccess: aaa"+resultBeans.toString());
        //获取成功
        mAdapter.addData(resultBeans);
    }

    private static final String TAG = "HomeActivity";
    @Override
    public void onFail(String msg) {
        Log.d(TAG, "onFail: "+msg);
    }
}
