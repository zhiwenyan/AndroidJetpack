package com.steven.androidjetpack.paging;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.room.User;

/**
 * Description:
 * Data：9/30/2018-11:17 AM
 *
 * @author yanzhiwen
 */
public class UserAdapter extends PagedListAdapter<User, UserViewHolder> {
    private Context mContext;
    private static final DiffUtil.ItemCallback<User> diffCallback = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(User oldItem, User newItem) {
            return oldItem.getUid() == newItem.getUid();
        }

        @Override
        public boolean areContentsTheSame(User oldItem, User newItem) {
            return oldItem.equals(newItem);
        }
    };

    public UserAdapter(Context context) {
        super(diffCallback);
        this.mContext =context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = getItem(position);
        if (user != null) {
            holder.tv_name.setText(user.getUserName());
            holder.tv_age.setText(user.getAge() + "");
        }
    }
}
