package com.steven.androidjetpack;

import android.app.Application;

import com.steven.androidjetpack.room.AppDatabase;
import com.steven.androidjetpack.room.AppExecutors;
import com.steven.androidjetpack.room.UserRepository;

/**
 * 全局的Application
 */
public class BasicApp extends Application {
    private static AppDatabase mAppDatabase;
    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        mAppDatabase = AppDatabase.getInstance(this, mAppExecutors);
        return mAppDatabase;
    }

    public UserRepository getRepository() {
        return UserRepository.getInstance(getDatabase());
    }

}
