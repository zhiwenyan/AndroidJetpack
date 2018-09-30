package com.steven.androidjetpack.room;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.paging.UserAdapter;
import com.steven.androidjetpack.paging.UserPagingViewModel;


public class UserInfoActivity extends AppCompatActivity {
    private static final String TAG = UserInfoActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private UserPagingViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        mRecyclerView = findViewById(R.id.recycler_view);
        UserPagingViewModel.Factory factory = new UserPagingViewModel.Factory(this.getApplication());
        mViewModel = ViewModelProviders.of(this, factory).get(UserPagingViewModel.class);
        subscribeUi();

    }

    private void subscribeUi() {
//        Observer<List<User>> observer = new Observer<List<User>>() {
//            @Override
//            public void onChanged(@Nullable List<User> users) {
//                if (users != null) {
//                    UserAdapter userAdapter = new UserAdapter(UserInfoActivity.this, users, R.layout.user_item);
//                    mRecyclerView.setAdapter(userAdapter);
//                }
//            }
//        };
        mViewModel.getObservableUsers().observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(@Nullable PagedList<User> users) {
                showUsers(users);
            }
        });

    }

    private void showUsers(PagedList<User> users) {
        UserAdapter userAdapter = new UserAdapter(UserInfoActivity.this);
        userAdapter.submitList(users);
        Log.i(TAG, "onChanged: "+users.getPositionOffset());
        mRecyclerView.setAdapter(userAdapter);
    }

//    private static class UserAdapter extends BaseRecycleAdapter<User> {
//
//        public UserAdapter(Context context, List<User> mDatas, int layoutId) {
//            super(context, mDatas, layoutId);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder holder, User user, int position) {
//            holder.setText(R.id.tv_name, user.getUserName())
//                    .setText(R.id.tv_age, user.getAge() + "");
//        }
//    }
}
