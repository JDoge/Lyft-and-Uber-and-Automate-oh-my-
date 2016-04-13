package com.example.larry_mbp.lyftanduberandautomateohmy;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import android.util.Log;

/**
 * Created by Larry-mbp on 4/13/16.
 */
public class LyftUberNotificationListener extends NotificationListenerService {

    private String TAG = this.getClass().getSimpleName();
    private Gson jsonSerializer = null;

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

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn)
    {
        //Remove our notification
        System.out.println("name: ");
    }
}
