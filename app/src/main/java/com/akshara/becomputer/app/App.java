package com.akshara.becomputer.app;

import android.app.Application;

import com.akshara.becomputer.database.AppDatabase;

public class App extends Application {
    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
    }

    private void initDb() {
        db = AppDatabase.getInstance(getApplicationContext());
    }
}
