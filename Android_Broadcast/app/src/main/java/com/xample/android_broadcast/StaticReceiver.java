package com.xample.android_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StaticReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String sex = intent.getStringExtra("sex");
        System.out.println("----StaticReceiver-----" + sex);
    }
}
