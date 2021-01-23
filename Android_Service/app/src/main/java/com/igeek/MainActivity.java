package com.igeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;

/**
 * 解绑生命周期在onDestroy前会先onUnBind
 */

// 绑定的时候要创建连接
public class MainActivity extends AppCompatActivity implements ServiceConnection {
    Intent in;
    MyService.MyBinder my;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in = new Intent();
        in.setClass(this,MyService.class);

        // 启动service服务
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in.putExtra("sex","男");
                startService(in);
            }
        });

        // 停止service服务
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(in);
            }
        });

        // 启动绑定service服务
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 自带绑定创建连接
                bindService(in, MainActivity.this, BIND_AUTO_CREATE);
            }
        });

        // 解绑service服务
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(MainActivity.this);
            }
        });

        // Binder传参
        et1 = findViewById(R.id.et1);
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my.setName(et1.getText().toString());
            }
        });
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        my = (MyService.MyBinder) iBinder;

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}