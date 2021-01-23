package com.igeek;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }
    Boolean flg = true;
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("---MyService---oncCreate");
        new Thread(){
            @Override
            public void run() {
                while (flg) {
                    System.out.println("------MyService------" + name);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    // 普通Service会走到onStartCommand方法，绑定Service不会，会走到onBind方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String sex = intent.getStringExtra("sex");
        System.out.println("---MyService---onStartCommand---" + sex);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flg = false;
        System.out.println("---MyService---onDestroy---");
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("---MyService---onBind---");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("---MyService---onUnBind---");
        return super.onUnbind(intent);
    }
    String name ="";

    class MyBinder extends Binder {
        void setName(String n) {
            name = n;
        }
    }
}
