package com.zhsolomyana.instagramclone;

import android.app.Application;

import com.parse.Parse;

import okhttp3.OkHttpClient;

public class ParseApplication<HttpLoggingInterceptor> extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Use for troubleshooting -- remove this line for production
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        // Use for monitoring Parse OkHttp traffic
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        // See http://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        // Register your parse models
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Yg7OmTfJSKMnV1Y7F1BdY1eDil6K2Zw7JySkBPxg")
                .clientKey("s63BpXuZJuEKvMuvPYnmiBFThEqwnFanRfp0K9Fm")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
