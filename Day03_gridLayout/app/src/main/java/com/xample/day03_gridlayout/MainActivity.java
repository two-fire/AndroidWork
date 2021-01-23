package com.xample.day03_gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mytext);

        //获取textview控件
        tv = findViewById(R.id.textView);
        tv.setText("abc");

        //获取button控件
        Button bt = findViewById(R.id.button);
        //添加点击事件
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("我被点了~");
            }
        });

        //获取Imagebutton控件
        ImageButton ibt = findViewById(R.id.imageButton);
        //添加点击事件
        ibt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("我又被点了！");
            }
        });
    }
}