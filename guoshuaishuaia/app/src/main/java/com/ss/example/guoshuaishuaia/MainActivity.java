package com.ss.example.guoshuaishuaia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

//郭帅帅 1810A 身份证号：142326199910026992
public class MainActivity extends AppCompatActivity {

    /**
     * 欢迎来到北京积云教育
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1.0f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.start();
        mTv.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
