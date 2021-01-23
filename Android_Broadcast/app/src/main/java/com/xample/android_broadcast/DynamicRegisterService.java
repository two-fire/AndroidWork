package com.xample.android_broadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class DynamicRegisterService extends Service {
    public DynamicRegisterService() {
    }
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicSystemReceiver ds = new DynamicSystemReceiver();
        IntentFilter f = new IntentFilter();
        f.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(ds,f);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
