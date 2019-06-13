package com.ss.example.guoshuaishuaia.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ss.example.guoshuaishuaia.R;
import com.ss.example.guoshuaishuaia.VpActivity;
import com.ss.example.guoshuaishuaia.bean.JokeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

public class VpAdapter extends PagerAdapter {
    private Context mContext;
    private List<JokeBean.ResultBean> mResultBeans;

    public VpAdapter(Context context, List<JokeBean.ResultBean> resultBeans) {

        mContext = context;
        mResultBeans = resultBeans;
    }

    @Override
    public int getCount() {
        return mResultBeans.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (View) o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.vp_item, null);
           ImageView iv= inflate.findViewById(R.id.iv);
           TextView tv1= inflate.findViewById(R.id.tv1);
           TextView tv2= inflate.findViewById(R.id.tv2);
        JokeBean.ResultBean bean = mResultBeans.get(position);
        Glide.with(mContext).load(bean.getHeader()).into(iv);
        tv1.setText(bean.getText());
        tv2.setText((position+1)+"/"+mResultBeans.size());
        container.addView(inflate);
        return inflate;
    }
}
