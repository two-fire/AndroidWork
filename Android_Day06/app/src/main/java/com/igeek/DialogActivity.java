package com.igeek;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import static java.lang.Thread.sleep;

public class DialogActivity extends AppCompatActivity {
    TextView tv;
    ProgressDialog pd;
    int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        tv = findViewById(R.id.textView2);
        Button bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab =
                        new AlertDialog.Builder(DialogActivity.this);
                ab.setMessage("中午吃饭吗？");
                // 确定按钮
                ab.setPositiveButton("吃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv.setText("吃鸭血粉丝！");
                    }
                });
                // 取消按钮
                ab.setNegativeButton("不吃", null);
                ab.show();
            }
        });

        // 单选对话框
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab =
                        new AlertDialog.Builder(DialogActivity.this);
                ab.setTitle("你喜欢哪门语言？");
                String[] s = {"C++", "Python", "Java", "Rust"};
                // 选中触发事件
                ab.setSingleChoiceItems(s, 4, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0: tv.setText("喜欢C++");break;
                            case 1: tv.setText("喜欢Python");break;
                            case 2: tv.setText("喜欢Java");break;
                            case 3: tv.setText("喜欢Rust");break;
                        }
                    }
                });
                ab.setPositiveButton("确定", null);
                ab.setNegativeButton("取消",null);
                ab.show();
            }
        });

        // 多选对话框
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab =
                        new AlertDialog.Builder(DialogActivity.this);
                ab.setTitle("你喜欢哪门语言？");
                String[] s = {"C++", "Python", "Java", "Rust"};
                // 选中触发事件
                ab.setMultiChoiceItems(s, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        switch (i) {
                            case 0: tv.append("C++");break;
                            case 1: tv.append("Python");break;
                            case 2: tv.append("Java");break;
                            case 3: tv.append("Rust");break;
                        }
                    }
                });
                ab.setPositiveButton("确定", null);
                ab.setNegativeButton("取消",null);
                ab.show();
        }
        });

        // 进度对话框
        findViewById(R.id.bt4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd = new ProgressDialog(DialogActivity.this);
                pd.setTitle("xx网站");
                pd.setMessage("正在下载中。。。");
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.show();
                new Thread() {
                    public void run() {
                        while (i <= 110) {
//                            pd.incrementProgressBy(10);
                            pd.setProgress(i);
                            i += new Random().nextInt(10);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
            }
        });

        // 普通（自定义）对话框
        findViewById(R.id.bt5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(DialogActivity.this);
                dialog.setContentView(R.layout.dialog_view);
                dialog.show();
            }
        });

        // 消息提示
        findViewById(R.id.bt6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DialogActivity.this,
                        "小可爱", Toast.LENGTH_LONG).show();
            }
        });

        // 通知提示框
        findViewById(R.id.bt7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nm =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder nb =
                        new Notification.Builder(DialogActivity.this);
                nb.setSmallIcon(R.mipmap.ic_launcher);
                nb.setContentTitle("通知提示框");
                nb.setContentText("这是一个通知提示框！");
                Notification no = nb.build();
                nm.notify(1, no);
            }
        });

    }
}