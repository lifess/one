package example.ss.com.commit1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import example.ss.com.commit1.FashionBean;
import example.ss.com.commit1.R;

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.MyViewHolder> {
    private Context mContext;
    private List<FashionBean.ResultBean.DataBean> mList = new ArrayList<>();

    public RlvAdapter(Context context) {

        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.fashion_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        FashionBean.ResultBean.DataBean dataBean = mList.get(i);
        myViewHolder.mTv.setText(dataBean.getTitle());
        Glide.with(mContext).load(dataBean.getThumbnail_pic_s()).into(myViewHolder.mIv);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateData(List<FashionBean.ResultBean.DataBean> dataBeans) {
        if (dataBeans != null) {
            mList.addAll(dataBeans);
            notifyDataSetChanged();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mIv;
        TextView mTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mIv = (ImageView) itemView.findViewById(R.id.iv);
            this.mTv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
