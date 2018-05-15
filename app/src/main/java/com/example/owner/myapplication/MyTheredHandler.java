package com.example.owner.myapplication;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import static java.lang.Thread.sleep;

class MyHandlerThread extends Thread {


    private boolean stopRunning = false;

    private WeakReference<Handler> handler;

    protected MyHandlerThread(Handler handler) {
        this.handler = new WeakReference<>(handler);
    }

    public void cancel()
    {
        stopRunning = true;
    }

    @Override
    public void run() {
        stopRunning = false;
        for (Integer i = 1; i < 10; i++) {
            if(stopRunning)
            {
                break;
            }
            try
            {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }



    }
}