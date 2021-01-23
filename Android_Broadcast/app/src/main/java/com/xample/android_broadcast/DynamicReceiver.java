package com.xample.android_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DynamicReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("-----DynamicReceiver-------"+
                intent.getStringExtra("sex"));
    }
}
