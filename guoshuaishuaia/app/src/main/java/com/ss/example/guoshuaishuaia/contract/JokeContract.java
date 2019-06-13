package com.ss.example.guoshuaishuaia.contract;

import com.ss.example.guoshuaishuaia.bean.JokeBean;

import java.util.List;

public interface JokeContract {
    interface Model {
        void getData(Callback callback);
    }

    interface View {
        void onSuccess(List<JokeBean.ResultBean> resultBeans);
        void onFail(String msg);
    }

    interface Presenter {
        void getNetWork();
    }
    interface Callback{
        void onSuccess(List<JokeBean.ResultBean> resultBeans);
        void onFail(String msg);
    }
}
