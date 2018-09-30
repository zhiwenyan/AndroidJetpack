package com.steven.androidjetpack.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.steven.androidjetpack.room.User;

import java.util.List;

/**
 * Description:ViewModel，从字面上理解的话，我们也能想到它肯定是跟视图(View)以及数据(Model)相关的。
 * 正像它字面意思一样，它是负责准备和管理和UI组件(Fragment/Activity)相关的数据类，也就是说ViewModel是用来管理UI相关的数据的。
 * 同时ViewModel还可以用来负责UI组件间的通信，这一点后面我们会有例子说明。
 *
 * https://blog.csdn.net/zhuzp_blog/article/details/78910535
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
