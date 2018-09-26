package com.steven.androidjetpack.room;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.steven.androidjetpack.BasicApp;
import com.steven.androidjetpack.R;
import com.steven.androidjetpack.recyclerview.BaseRecycleAdapter;
import com.steven.androidjetpack.recyclerview.BaseViewHolder;

import java.util.List;


public class UserInfoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<User> mUsers;
    private AppExecutors mAppExecutors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        mRecyclerView = findViewById(R.id.recycler_view);
        mAppExecutors = new AppExecutors();
        addDelay();


    }

    private void addDelay() {


        mAppExecutors.diskIO().execute(() -> {
            mUsers = (( BasicApp ) (UserInfoActivity.this.getApplication())).getRepository().getAllUsers();
        });

//        UserAdapter userAdapter = new UserAdapter(UserInfoActivity.this, mUsers, R.layout.user_item);
//        mRecyclerView.setAdapter(userAdapter);
    }

    private static class UserAdapter extends BaseRecycleAdapter<User> {
        public UserAdapter(Context context, List<User> mDatas, int layoutId) {
            super(context, mDatas, layoutId);
        }

        @Override
        protected void convert(BaseViewHolder holder, User user, int position) {
            holder.setText(R.id.tv_name, user.getUserName())
                    .setText(R.id.tv_age, user.getAge() + "");
        }
    }
}
