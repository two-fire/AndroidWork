package com.xample.android_aidl2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
    IMyAidl myAidl;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent();
                in.setComponent(new ComponentName("com.xample.android_aidl2_other",
                        "com.xample.android_aidl2_other.MyService"));
                // startService(in);
                bindService(in,MainActivity.this,BIND_AUTO_CREATE);
            }
        });
        et = findViewById(R.id.et);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    myAidl.setData(et.getText().toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        myAidl =IMyAidl.Stub.asInterface(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
