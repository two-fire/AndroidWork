package com.igeek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class TweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        iv = findViewById(R.id.imageView2);
        Button bt1 = findViewById(R.id.button);
        // this为当前类对象
        bt1.setOnClickListener(this);
        Button bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        Button bt3 = findViewById(R.id.button3);
        bt3.setOnClickListener(this);
        Button bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(this);
    }
    @Override
    public void onClick (View view){
        Animation an = null;
        if (view.getId() == R.id.button) {
            an = AnimationUtils.
                    loadAnimation(getApplicationContext(), R.anim.tween_alpha);
        } else if (view.getId() == R.id.bt2) {
            an = AnimationUtils.
                    loadAnimation(getApplicationContext(), R.anim.tween_scale);
        } else if (view.getId() == R.id.button3) {
            an = AnimationUtils.
                    loadAnimation(getApplicationContext(), R.anim.tween_translate);
        } else if (view.getId() == R.id.bt4) {
            an = AnimationUtils.
                    loadAnimation(getApplicationContext(), R.anim.tween_rotate);
        }
        //用特效把an放进去
        iv.startAnimation(an);
    }
}