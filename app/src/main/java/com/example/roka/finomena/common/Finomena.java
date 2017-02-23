package com.example.roka.finomena.common;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;

/**
 * Created by Roka on 1/20/2017.
 */

public class Finomena extends Application {
    private static Finomena mAppController;

    public static Finomena getInstance() {
        return mAppController;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppController = this;
    }

    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
