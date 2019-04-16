package com.steven.androidjetpack.paging;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.steven.androidjetpack.BasicApp;
import com.steven.androidjetpack.room.User;
import com.steven.androidjetpack.room.UserRepository;


/**
 * Description:分页加载的ViewModel
 * Data：9/30/2018-10:41 AM
 *
 * @author yanzhiwen
 */
public class UserPagingViewModel extends AndroidViewModel {
    //每页加载的数量
    private static final int PAGE_SIZE = 10;
    private UserRepository mUserRepository;
    private final LiveData<PagedList<User>> mObservableUsers;


    public UserPagingViewModel(@NonNull Application application, UserRepository userRepository) {
        super(application);
        this.mUserRepository = userRepository;
        mObservableUsers = new LivePagedListBuilder<>(mUserRepository.getAllUserByName(), new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(PAGE_SIZE * 2)
                .build()).build();
    }

    public LiveData<PagedList<User>> getObservableUsers() {
        return mObservableUsers;
    }

    public static final class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private Application mApplication;
        private UserRepository mRepository;

        public Factory(@NonNull Application application) {
            this.mApplication = application;
            mRepository = ((BasicApp) application).getRepository();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return (T) new UserPagingViewModel(mApplication, mRepository);
        }
    }
}
