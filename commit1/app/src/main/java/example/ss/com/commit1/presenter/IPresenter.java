package example.ss.com.commit1.presenter;

import java.util.List;

import example.ss.com.commit1.FashionBean;
import example.ss.com.commit1.contract.IContract;
import example.ss.com.commit1.model.IModel;

public class IPresenter implements IContract.Presenter {
    private IContract.View mView;
    private final IModel mIModel;

    public IPresenter(IContract.View view) {
        mIModel = new IModel();
        mView = view;
    }

    @Override
    public void getNetWork() {
        mIModel.requestData(new IContract.Callback() {
            @Override
            public void requestSuccess(List<FashionBean.ResultBean.DataBean> dataBeans) {
                mView.updateUiSuccess(dataBeans);
            }

            @Override
            public void requestFailed(String msg) {
                mView.updateUiFailed(msg);
            }
        });
    }
}
