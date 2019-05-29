package example.ss.com.commit1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import example.ss.com.commit1.adapter.RlvAdapter;
import example.ss.com.commit1.contract.IContract;
import example.ss.com.commit1.presenter.IPresenter;

public class MainActivity extends AppCompatActivity implements IContract.View {

    private RecyclerView mRlv;
    private RlvAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMvp();
    }

    private void initMvp() {
        IPresenter iPresenter = new IPresenter(this);
        iPresenter.getNetWork();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter = new RlvAdapter(this);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    public void updateUiSuccess(List<FashionBean.ResultBean.DataBean> dataBeans) {
        mAdapter.updateData(dataBeans);
    }

    private static final String TAG = "MainActivity";
    @Override
    public void updateUiFailed(String msg) {
        Log.d(TAG, "updateUiFailed: "+msg);
    }
}
