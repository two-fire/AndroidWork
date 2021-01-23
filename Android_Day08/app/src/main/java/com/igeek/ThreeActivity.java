package com.igeek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThreeActivity extends AppCompatActivity {
    EditText et;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        et = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 拨打电话
                Intent in = new Intent();
                in.setAction(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel:" + et.getText().toString());
                in.setData(uri);
                startActivity(in);
            }
        });

        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 访问网址
                Intent in = new Intent();
                in.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://" + et2.getText().toString());
                in.setData(uri);
                startActivity(in);
            }
        });

        findViewById(R.id.bt7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent();
                in.setAction("abc");
                startActivity(in);
            }
        });
    }
}