package com.igeek;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editTextTextPersonName);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,
                        TwoActivity.class);
                in.putExtra("name", et.getText().toString());
                // 110 代表跳转的是twoactivity
                startActivityForResult(in,110);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent();
                // 可以启动一个第三方应用，这里启动本项目
                in.setComponent(new ComponentName("com.igeek",
                        "com.igeek.TwoActivity"));
                startActivity(in);
            }
        });
    }

    @Override
    //                                     110 从twoactivity中返回的
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            String sex = data.getExtras().getString("sex");
            Toast.makeText(MainActivity.this,
                    requestCode + ":" + sex, Toast.LENGTH_LONG).show();
        }
    }

}