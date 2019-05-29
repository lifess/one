package example.ss.com.commit2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.MyViewHolder> {
    private List<UserBean> mList = new ArrayList<>();
    private Context mContext;

    public RlvAdapter(Context context) {

        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.user_name, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        UserBean userBean = mList.get(i);
        myViewHolder.mTv.setText(userBean.getName());
        myViewHolder.mIv.setImageResource(userBean.getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void reSetData(List<UserBean> userBeans) {
        if (userBeans != null) {
            mList.addAll(userBeans);
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
