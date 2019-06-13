package com.ss.example.guoshuaishuaia.model;

import com.ss.example.guoshuaishuaia.api.ApiService;
import com.ss.example.guoshuaishuaia.bean.JokeBean;
import com.ss.example.guoshuaishuaia.contract.JokeContract;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JokeModel implements JokeContract.Model {
    @Override
    public void getData(final JokeContract.Callback callback) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.mUrl)
                .build();
        build.create(ApiService.class).getJoke()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokeBean jokeBean) {
                        List<JokeBean.ResultBean> result = jokeBean.getResult();
                        int code = jokeBean.getCode();
                        if (code==200) {
                            if (result != null&&result.size()>0) {
                                callback.onSuccess(result);
                            }else {
                                callback.onFail("失败");
                            }
                        }else {
                            callback.onFail("fail");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
