package com.steven.androidjetpack.room;

import java.util.List;

/**
 * Description:
 * Data：9/25/2018-1:38 PM
 *
 * @author yanzhiwen
 */
public class UserRepository {
    private static volatile UserRepository sInstance;
    private final AppDatabase mDatabase;
    private AppExecutors mAppExecutors;

    private UserRepository(AppDatabase database) {
        this.mDatabase = database;
        this.mAppExecutors = new AppExecutors();
    }

    public static UserRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (UserRepository.class) {
                if (sInstance == null) {
                    sInstance = new UserRepository(database);
                }
            }
        }
        return sInstance;
    }

    public List<User> getAllUsers() {
        return mDatabase.userDao().getAllUsers();
    }

}
