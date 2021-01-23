package com.igeek;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {

    ImageView iv;
    AnimationDrawable ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        iv = findViewById(R.id.imageView);
        // 加载数据源
        iv.setBackgroundResource(R.drawable.frame);
        // 控制动画的关键 ad可开启可停止
        ad = (AnimationDrawable)iv.getBackground();
        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 在运行关闭;否则开始
                if(ad.isRunning()) {
                    ad.stop();
                } else {
                    ad.start();
                }
            }
        });
    }
}