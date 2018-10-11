package com.steven.androidjetpack.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.steven.androidjetpack.R;

/**
 * Description:
 * Data：10/11/2018-4:18 PM
 *
 * @author yanzhiwen
 */
public class UserProfile extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        String name = "";
        if (getArguments() != null) {
            name = getArguments().getString("userName");
        }
        TextView tv_username = view.findViewById(R.id.profile_user_name);
        tv_username.setText(name);
        return view;

    }
}
