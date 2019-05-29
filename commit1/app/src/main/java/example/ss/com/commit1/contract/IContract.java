package example.ss.com.commit1.contract;

import java.util.List;

import example.ss.com.commit1.FashionBean;

public interface IContract {
    interface Model {
        void requestData(Callback callback);
    }

    interface View {
        void updateUiSuccess(List<FashionBean.ResultBean.DataBean> dataBeans);
        void updateUiFailed(String msg);
    }

    interface Presenter {
        void getNetWork();
    }
    interface Callback{
        void requestSuccess(List<FashionBean.ResultBean.DataBean> dataBeans);
        void requestFailed(String msg);
    }
}
