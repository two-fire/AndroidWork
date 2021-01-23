package com.xample.android_savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileActivity extends AppCompatActivity {
    EditText et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        et3 = findViewById(R.id.et3);
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 写入文件
                try {
                    // 底层流
                    FileOutputStream fo = openFileOutput("info",MODE_PRIVATE);
                    // 高层流 效率更高
                    BufferedOutputStream bs = new BufferedOutputStream(fo);

                    bs.write(et3.getText().toString().getBytes());
                    // 缓冲流最后一定要刷新缓冲区
                    bs.flush();
                    fo.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 读文件
                try {
                    // 底层流
                    FileInputStream fi = openFileInput("info");
                    // 高层流 效率更高
                    BufferedInputStream bs = new BufferedInputStream(fi);
                    byte[] b = new byte[2000];
                    bs.read(b);
                    Toast.makeText(FileActivity.this,new String(b),Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}