package com.example.larry_mbp.lyftanduberandautomateohmy;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final int REQUEST_NOTIFICATION_LISTENER = 12;
    public static Context ctx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = getApplicationContext();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.sun);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 1, intent, 0);
        builder.setContentIntent(pIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notif = builder.build();
        mNotificationManager.notify(1, notif);

        Toast.makeText(MainActivity.this, "App started", Toast.LENGTH_SHORT).show();

        ctx = this;

        LinearLayout rootLayout = new LinearLayout(this);

        ContentResolver contentResolver = this.getContentResolver();
        String[] enabledNotificationListeners = Settings.Secure.getString(contentResolver, "enabled_notification_listeners").split(":");
        ArrayList<String> enabledNotificationListenersArrayList = new ArrayList<String>();
        for (String item : enabledNotificationListeners) {
            enabledNotificationListenersArrayList.add(item);
        }
        String packageName = this.getPackageName();
        packageName = packageName + "/com.example.larry_mbp.lyftanduberandautomateohmy.LyftUberNotificationListener";

        //packageName = "com.example.larry_mbp.lyftanduberandautomateohmy/com.example.larry_mbp.lyftanduberandautomateohmy.LyftUberNotificationListener";

        // check to see if the enabledNotificationListeners String contains our package name
        if (!enabledNotificationListenersArrayList.contains(packageName)) {

            // User does not have Notification Access Permission enabled for this app.
            // Present user with Notification Access settings screen.
            //Intent intent = new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
            //startActivity(intent);

            startActivityForResult(new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS), 0);
        } else {
            //listener = new LyftUberNotificationListener();
            System.out.println();
        }

        if (Build.VERSION.SDK_INT >= 23) {

//            if(checkSelfPermission(Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE) == PackageManager.PERMISSION_GRANTED) {
//
//                // User already has required permissions.
//                System.out.println();
//            }
//            else {
//
//                // User does not have required permissions. Request them from user.
//                if(shouldShowRequestPermissionRationale(Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
//
//                    Toast.makeText(this, "Notification permission is required", Toast.LENGTH_SHORT).show();
//                }
//
//                requestPermissions(new String[] { Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE },
//                        REQUEST_NOTIFICATION_LISTENER);
//            }
        }

        Button b1 = new Button(this);
        b1.setText("Send Notification");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        rootLayout.addView(b1, new LinearLayout.LayoutParams(displaymetrics.widthPixels, 200, 0));

        b1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        SendNotification("Notification Alert, Click Me!", "Hi, This is Android Notification Detail!");
                    }
                }
        );

        setContentView(rootLayout);
    }

    public void SendNotification(String title, String message) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(ctx);

        mBuilder.setSmallIcon(R.drawable.on);
        mBuilder.setContentTitle(title);
        mBuilder.setContentText(message);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(0, mBuilder.build());
    }

    @Override
    protected void onResume() {
        super.onResume();

        ctx = this;

        //listener = new LyftUberNotificationListener();
        //listener = new LyftUberNotificationListener();

//        ContentResolver contentResolver = this.getContentResolver();
//        String[] enabledNotificationListeners = Settings.Secure.getString(contentResolver, "enabled_notification_listeners").split(":");
//        ArrayList<String> enabledNotificationListenersArrayList = new ArrayList<String>();
//        for (String item : enabledNotificationListeners) {
//            enabledNotificationListenersArrayList.add(item);
//        }
//        String packageName = this.getPackageName();
//        packageName = packageName + "/com.example.larry_mbp.lyftanduberandautomateohmy.LyftUberNotificationListener";
//
//        // check to see if the enabledNotificationListeners String contains our package name
//        if (enabledNotificationListenersArrayList.contains(packageName))
//        {
//            startActivity(new Intent(this, MainActivity.class));
//            finish();
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

//        if(requestCode == REQUEST_NOTIFICATION_LISTENER) {
//
//            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission has been granted.
//            }
//            else {
//                // Permission was denied.
//                Toast.makeText(this, "Permission was not granted", Toast.LENGTH_SHORT).show();
//            }
//        }
//        else {
//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        }
    }

    private boolean checkNotificationPermission(Context ctx) {
        PackageManager pm = ctx.getPackageManager();
        int hasPerm = pm.checkPermission(
                Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE,
                ctx.getPackageName());
        if (hasPerm == PackageManager.PERMISSION_GRANTED) {
            return true;
        }

//        PackageManager pm = getPackageManager();
//        if (pm.checkPermission(Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE, getPackageName()) == PackageManager.PERMISSION_GRANTED) {
//            // do something
//            return true;
//        } else {
//            // do something
//        }

//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(ctx.getPackageName(), PackageManager.GET_PERMISSIONS);
//            if (info.requestedPermissions != null) {
//                for (String p : info.requestedPermissions) {
//                    if (p.equals("BIND_NOTIFICATION_LISTENER_SERVICE")) {
//                        return true;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return false;
    }
}
