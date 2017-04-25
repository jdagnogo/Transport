package com.example.jdagnogo.transport;

import android.app.Application;
import android.content.Context;

public class TransportApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        this.context = this;
        super.onCreate();
    }

    public static Context getAppContext(){
        return context;
    }
}
