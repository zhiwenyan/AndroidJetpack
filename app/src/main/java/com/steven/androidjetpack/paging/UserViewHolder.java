package com.steven.androidjetpack.paging;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.steven.androidjetpack.R;

/**
 * Description:
 * Data：9/30/2018-11:22 AM
 *
 * @author yanzhiwen
 */
public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_name;
    public TextView tv_age;

    public UserViewHolder(View itemView) {
        super(itemView);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_age = itemView.findViewById(R.id.tv_age);
    }
}
