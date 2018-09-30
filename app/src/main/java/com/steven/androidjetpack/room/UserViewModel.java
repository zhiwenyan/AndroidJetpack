package com.steven.androidjetpack.room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.steven.androidjetpack.BasicApp;

import java.util.List;

/**
 * Description:
 * Data：9/27/2018-9:42 AM
 *
 * @author yanzhiwen
 */
public class UserViewModel extends AndroidViewModel {
    private final LiveData<List<User>> mObservableUsers;
    private UserRepository mUserRepository;

    public UserViewModel(@NonNull Application application, UserRepository repository) {
        super(application);
        this.mUserRepository = repository;
        mObservableUsers = mUserRepository.getAllUsers();
    }

    public LiveData<List<User>> getObservableUsers() {
        return mObservableUsers;
    }


    /**
     * A creator is used to inject the product ID into the ViewModel
     * <p>
     * This creator is to showcase how to inject dependencies into ViewModels. It's not
     * actually necessary in this case, as the product ID can be passed in a public method.
     */

    //通过方法工厂创建一个ViewModel
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;
        private final UserRepository mRepository;

        Factory(@NonNull Application application) {
            mApplication = application;
            mRepository = (( BasicApp ) application).getRepository();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return ( T ) new UserViewModel(mApplication, mRepository);
        }
    }
}
