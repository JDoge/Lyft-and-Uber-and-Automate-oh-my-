package com.example.larry_mbp.lyftanduberandautomateohmy;

/**
 * Created by Larry-mbp on 4/15/16.
 */
public class NotificationADM
{
    String PackageName;
    String Provider;
    String Data;

    public NotificationADM()
    {
        PackageName = "me.lyft.android";
        Provider = "Lyft";
        Data = "Hello, Gary";
    }

    public NotificationADM(String packageName, String provider, String data)
    {
        PackageName = packageName;
        Provider = provider;
        Data = data;
    }
}
