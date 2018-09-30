package com.steven.androidjetpack.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.steven.androidjetpack.BasicApp;

import java.util.List;

/**
 * Description:
 * Data：9/27/2018-10:50 AM
 *
 * @author yanzhiwen
 */
public class UserListViewModel extends AndroidViewModel {
    private final MediatorLiveData<List<User>> mObserverUsers;

    public UserListViewModel(@NonNull Application application) {
        super(application);
        mObserverUsers = new MediatorLiveData<>();
        mObserverUsers.setValue(null);
        LiveData<List<User>> users = (( BasicApp ) application).getRepository()
                .getAllUsers();

        // observe the changes of the products from the database and forward them
        mObserverUsers.addSource(users, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                mObserverUsers.setValue(users);

            }
        });

    }

    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<User>> getUsers() {
        return mObserverUsers;
    }
}
