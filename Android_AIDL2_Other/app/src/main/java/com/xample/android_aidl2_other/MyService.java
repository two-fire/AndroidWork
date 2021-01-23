package com.xample.android_aidl2_other;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.xample.android_aidl2.IMyAidl;

public class MyService extends Service {
    public MyService() {
    }



    @Override
    public void onCreate() {
        super.onCreate();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("---other service---" + data);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myAidl;
    }
    String data = "";
    IMyAidl.Stub myAidl = new IMyAidl.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                               double aDouble, String aString) throws RemoteException {
        }

        @Override
        public void setData(String d) throws RemoteException {
            data = d;
        }
    };

}
