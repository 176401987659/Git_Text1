package com.example.git_text.base;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseApplication sBaseApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        sBaseApplication = this;
    }

    public static BaseApplication getBaseApplication() {
        return sBaseApplication;
    }
}
