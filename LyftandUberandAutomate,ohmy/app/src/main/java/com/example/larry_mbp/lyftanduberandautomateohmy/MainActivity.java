package com.example.larry_mbp.lyftanduberandautomateohmy;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Listener created");

        LinearLayout rootLayout = new LinearLayout(this);

        final Context c = this;

        //Button b1 = (Button)findViewById(R.id.button);
        Button b1 = new Button(this);
        b1.setText("Send Notification");
        rootLayout.addView(b1, new LinearLayout.LayoutParams(500, 100, 0));

        b1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(c);

                        mBuilder.setSmallIcon(R.drawable.on);
                        mBuilder.setContentTitle("Notification Alert, Click Me!");
                        mBuilder.setContentText("Hi, This is Android Notification Detail!");

                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                        mNotificationManager.notify(0, mBuilder.build());
                    }
                }
        );

        setContentView(rootLayout);
    }
}
