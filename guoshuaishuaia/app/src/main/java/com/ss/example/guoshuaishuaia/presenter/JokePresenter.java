package com.ss.example.guoshuaishuaia.presenter;

import com.ss.example.guoshuaishuaia.bean.JokeBean;
import com.ss.example.guoshuaishuaia.contract.JokeContract;
import com.ss.example.guoshuaishuaia.model.JokeModel;

import java.util.List;

public class JokePresenter implements JokeContract.Presenter {
    private JokeContract.View mView;
    private final JokeModel mJokeModel;

    public JokePresenter(JokeContract.View view) {
        mJokeModel = new JokeModel();
        mView = view;
    }

    @Override
    public void getNetWork() {
        mJokeModel.getData(new JokeContract.Callback() {
            @Override
            public void onSuccess(List<JokeBean.ResultBean> resultBeans) {
                mView.onSuccess(resultBeans);
            }

            @Override
            public void onFail(String msg) {
                mView.onFail(msg);
            }
        });
    }
}
