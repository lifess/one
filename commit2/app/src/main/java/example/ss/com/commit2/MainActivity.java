package example.ss.com.commit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

//郭帅帅 1810A
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRlv;
    private RlvAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initQueryAll();
    }

    private void initQueryAll() {
        List<UserBean> userBeans = DBUtils.queryAll();
        mAdapter.reSetData(userBeans);
        if (userBeans.size()==0) {
            initInsert();
        }
    }

    private void initInsert() {
        for (int i = 0; i < 20; i++) {
            UserBean userBean = new UserBean(null, "张三" + i, R.mipmap.ic_launcher);
            DBUtils.insert(userBean);
        }
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter = new RlvAdapter(this);
        mRlv.setAdapter(mAdapter);
    }
}
