package com.xample.android_broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.setAction("static");
                in.putExtra("sex","男");
                in.setComponent(new ComponentName("com.xample.android_broadcast",
                        "com.xample.android_broadcast.StaticReceiver"));
                sendBroadcast(in);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DynamicReceiver dr =new DynamicReceiver();
                IntentFilter filter = new IntentFilter();
                // 设置action
                filter.addAction("dynamic");
                //动态注册
                registerReceiver(dr,filter);

            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.putExtra("sex","女");
                in.setAction("dynamic");
                sendBroadcast(in);
            }
        });
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,DynamicRegisterService.class);
                startService(in);
            }
        });
    }
}