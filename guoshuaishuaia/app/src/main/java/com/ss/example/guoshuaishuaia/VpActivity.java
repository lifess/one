package com.ss.example.guoshuaishuaia;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ss.example.guoshuaishuaia.adapter.VpAdapter;
import com.ss.example.guoshuaishuaia.bean.JokeBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class VpActivity extends AppCompatActivity {

    private ViewPager mVp;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        initView();
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void MyEventBus(OnEventBus eventBus) {
        List<JokeBean.ResultBean> resultBeans = eventBus.mResultBeans;
        int position = eventBus.position;
        VpAdapter adapter = new VpAdapter(this, resultBeans);
        mVp.setAdapter(adapter);
        mVp.setCurrentItem(position);
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("图册");
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
