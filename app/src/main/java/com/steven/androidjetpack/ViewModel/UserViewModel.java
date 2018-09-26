package com.steven.androidjetpack.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.steven.androidjetpack.room.User;

import java.util.List;

/**
 * Description:
 * Data：9/26/2018-4:52 PM
 *
 * @author yanzhiwen
 */
public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;

    public MutableLiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadUsers();

        }
        return users;
    }
    private void loadUsers() {
        // do async operation to fetch users
    }
}
