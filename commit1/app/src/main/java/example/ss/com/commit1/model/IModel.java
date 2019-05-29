package example.ss.com.commit1.model;

import java.util.List;

import example.ss.com.commit1.ApiService;
import example.ss.com.commit1.FashionBean;
import example.ss.com.commit1.GetData;
import example.ss.com.commit1.contract.IContract;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class IModel implements IContract.Model {
    @Override
    public void requestData(final IContract.Callback callback) {
        ApiService apiService = GetData.getApiService();
        apiService.getFashion()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FashionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FashionBean fashionBean) {
                        List<FashionBean.ResultBean.DataBean> data = fashionBean.getResult().getData();
                        callback.requestSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.requestFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
