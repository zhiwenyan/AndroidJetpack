package com.steven.androidjetpack.room;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;

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

    private UserRepository(AppDatabase database) {
        this.mDatabase = database;
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

    public LiveData<List<User>> getAllUsers() {
        return mDatabase.userDao().getAllUsers();
    }

    public DataSource.Factory<Integer, User> getAllUserByName() {
        return mDatabase.userDao().getAllUserByName();
    }

    public User getUserByName(String name) {
        return mDatabase.userDao().findByName(name);
    }

}
