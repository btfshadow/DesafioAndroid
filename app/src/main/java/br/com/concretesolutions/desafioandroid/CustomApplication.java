package br.com.concretesolutions.desafioandroid;

import android.app.Application;

import timber.log.Timber;


public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }
}
