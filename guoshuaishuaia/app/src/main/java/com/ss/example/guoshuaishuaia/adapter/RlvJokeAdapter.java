package com.ss.example.guoshuaishuaia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ss.example.guoshuaishuaia.R;
import com.ss.example.guoshuaishuaia.bean.JokeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RlvJokeAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<JokeBean.ResultBean> list = new ArrayList<>();
    private onItemClick mItemClick;

    public RlvJokeAdapter(Context context) {

        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position % 3 == 1) {
            return 1;
        } else if (position % 3 == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.ban_item, viewGroup, false);
            return new JokeViewHolder1(inflate);
        } else if (i == 1) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.home_item, viewGroup, false);
            return new JokeViewHolder2(inflate);
        } else if (i == 2) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.home_item2, viewGroup, false);
            return new JokeViewHolder3(inflate);
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.home_item3, viewGroup, false);
            return new JokeViewHolder4(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        final JokeBean.ResultBean bean = list.get(i);
        if (type == 0) {
            JokeViewHolder1 holder1= (JokeViewHolder1) viewHolder;
            holder1.mBanner.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    JokeBean.ResultBean path1 = (JokeBean.ResultBean) path;
                    Glide.with(mContext).load(path1.getHeader()).into(imageView);
                }
            }).start();
        }else if (type == 1) {
            JokeViewHolder2 holder2= (JokeViewHolder2) viewHolder;
            holder2.mTvBody.setText(bean.getText());
            holder2.mTvTitle.setText(bean.getName());
            Glide.with(mContext).load(bean.getThumbnail()).into(holder2.mIv);
        }else if (type == 2) {
            JokeViewHolder3 holder3= (JokeViewHolder3) viewHolder;
            holder3.mTvTitle1.setText(bean.getName());
            holder3.mTvBody1.setText(bean.getText());
            Glide.with(mContext).load(bean.getThumbnail()).into(holder3.mIv1);
            Glide.with(mContext).load(bean.getThumbnail()).into(holder3.mIv2);
        }else {
            JokeViewHolder4 holder4= (JokeViewHolder4) viewHolder;
            holder4.mTvTitle3.setText(bean.getName());
            holder4.mTvBody3.setText(bean.getText());
            Glide.with(mContext).load(bean.getThumbnail()).into(holder4.mIv1);
            Glide.with(mContext).load(bean.getThumbnail()).into(holder4.mIv2);
            Glide.with(mContext).load(bean.getThumbnail()).into(holder4.mIv3);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClick != null) {
                    mItemClick.onItem(list,i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<JokeBean.ResultBean> resultBeans) {
        if (resultBeans != null && resultBeans.size() > 0) {
            list.addAll(resultBeans);
            notifyDataSetChanged();
        }
    }

    class JokeViewHolder1 extends RecyclerView.ViewHolder {
        Banner mBanner;

        public JokeViewHolder1(@NonNull View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.ban);
        }
    }

    class JokeViewHolder2 extends RecyclerView.ViewHolder {
        TextView mTvTitle;
        ImageView mIv;
        TextView mTvBody;

        public JokeViewHolder2(@NonNull View itemView) {
            super(itemView);
            this.mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.mIv = (ImageView) itemView.findViewById(R.id.iv);
            this.mTvBody = (TextView) itemView.findViewById(R.id.tv_body);
        }
    }

    class JokeViewHolder3 extends RecyclerView.ViewHolder {
        TextView mTvTitle1;
        ImageView mIv1;
        ImageView mIv2;
        TextView mTvBody1;

        public JokeViewHolder3(@NonNull View itemView) {
            super(itemView);
            this.mTvTitle1 = (TextView) itemView.findViewById(R.id.tv_title1);
            this.mIv1 = (ImageView) itemView.findViewById(R.id.iv1);
            this.mIv2 = (ImageView) itemView.findViewById(R.id.iv2);
            this.mTvBody1 = (TextView) itemView.findViewById(R.id.tv_body1);
        }
    }

    class JokeViewHolder4 extends RecyclerView.ViewHolder {
        TextView mTvTitle3;
        ImageView mIv1;
        ImageView mIv2;
        ImageView mIv3;
        TextView mTvBody3;
        public JokeViewHolder4(@NonNull View itemView) {
            super(itemView);
            this.mTvTitle3 = (TextView) itemView.findViewById(R.id.tv_title3);
            this.mIv1 = (ImageView) itemView.findViewById(R.id.iv1);
            this.mIv2 = (ImageView) itemView.findViewById(R.id.iv2);
            this.mIv3 = (ImageView) itemView.findViewById(R.id.iv3);
            this.mTvBody3 = (TextView) itemView.findViewById(R.id.tv_body3);
        }
    }
   public interface onItemClick{
        void onItem(List<JokeBean.ResultBean> resultBean,int position);
    }
    public void  setonItemClick(onItemClick itemClick){

        mItemClick = itemClick;
    }
}
