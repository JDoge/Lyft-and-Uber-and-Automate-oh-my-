package com.example.larry_mbp.lyftanduberandautomateohmy;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Larry-mbp on 4/15/16.
 */
public class ApiService {

    public Retrofit retrofit = null;
    public ApiServiceInterface service = null;

    public ApiService()
    {
        //String url = "http://winhost:1243/api/";
        String url = "http://autodrivemodeapi.mte43jwchi.us-west-2.elasticbeanstalk.com/api/";

        retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        service = retrofit.create(ApiServiceInterface.class);
    }

    public void ApiPost(NotificationADM notification)
    {
        // POST
        Call<NotificationADM> call = service.PostNotification(notification);
        call.enqueue(new Callback<NotificationADM>() {

            @Override
            public void onResponse(Response<NotificationADM> response, Retrofit retrofit) {
                int statusCode = response.code();
                System.out.println();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println();
            }
        });
    }

    public interface ApiServiceInterface {

        @POST("notifications")
        Call<NotificationADM> PostNotification(
                @Body NotificationADM notification
        );
    }
}
