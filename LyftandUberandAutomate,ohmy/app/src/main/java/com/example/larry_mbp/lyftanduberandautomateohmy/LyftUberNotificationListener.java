package com.example.larry_mbp.lyftanduberandautomateohmy;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by Larry-mbp on 4/13/16.
 */
public class LyftUberNotificationListener extends NotificationListenerService {

    private String TAG = this.getClass().getSimpleName();
    private Gson jsonSerializer = null;
    public static Context ctx = null;

    @Override
    public IBinder onBind(Intent intent)
    {
        ctx = MainActivity.ctx;
        return super.onBind(intent);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        GsonBuilder builder = new GsonBuilder();
        jsonSerializer = builder.create();
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn)
    {
        String json = jsonSerializer.toJson(sbn);
        String packageName = sbn.getPackageName();
        //Notificaction n = sbn.getNotification();
        String rawString = sbn.toString();
        Log.d(TAG, "json: " + json);


        if(packageName == "com.ubercab" || packageName == "me.lyft.android" || true)
        {
            ApiService apiService = new ApiService();
            apiService.ApiPost(new NotificationADM());
        }

//        Handler handler = new Handler(Looper.getMainLooper());
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.ctx, "Notification Alert", Toast.LENGTH_SHORT).show();
//            }
//        };
//        handler.post(r);
    }

    public void ApiPost(String jsonData)
    {
//        try {
//
//            new AsyncNetworkRequest().execute();
//
//
//        } catch(Exception e) {
//            System.out.println();
//        }
    }



    @Override
    public void onNotificationRemoved(StatusBarNotification sbn)
    {
        //Remove our notification
        System.out.println("name: ");
    }
}

