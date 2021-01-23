package com.xample.android_savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor se = sp.edit();
                se.putString("name",et1.getText().toString());
                se.putString("pwd",et2.getText().toString());
                se.commit();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sp.getString("name","张三");
                String pwd = sp.getString("pwd","空");
                Toast.makeText(MainActivity.this,"账号"+name+",密码"+pwd,Toast.LENGTH_LONG).show();
            }
        });

    }
}