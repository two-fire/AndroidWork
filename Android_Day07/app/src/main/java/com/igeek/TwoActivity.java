package com.igeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TwoActivity extends AppCompatActivity {
    // 1. 创建
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        System.out.println("---TwoActivity----onCreate");
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // 2. 启动 模拟机上可见，但不能交互
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("---TwoActivity----onStart");
    }

    // 3. 用户与activity能进行交互
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("---TwoActivity----onResume");
    }

    // 4. 暂停 能看见但不能操作了
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("---TwoActivity----onPause");
    }
    // 5. 停止 activity已经挂到后台看不见了
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("---TwoActivity----onStop");
    }
    // 6. 销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("---TwoActivity----onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("---TwoActivity----onRestart");
    }

}