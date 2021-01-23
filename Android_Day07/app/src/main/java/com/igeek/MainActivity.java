package com.igeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // 1. 创建
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("---MainActivity----onCreate");
    }

    // 2. 启动 模拟机上可见，但不能交互
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("---MainActivity----onStart");
    }

    // 3. 用户与activity能进行交互
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        System.out.println("---MainActivity----onResume");
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(in);
            }
        });
    }

    // 4. 暂停 能看见但不能操作了
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("---MainActivity----onPause");
    }
    // 5. 停止 activity已经挂到后台看不见了
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("---MainActivity----onStop");
    }
    // 6. 销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("---MainActivity----onDestroy");
    }

}