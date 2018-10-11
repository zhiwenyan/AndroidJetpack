package com.steven.androidjetpack.navigation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.recyclerview.BaseRecycleAdapter;
import com.steven.androidjetpack.recyclerview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.Navigation;

/**
 * Description:
 * Data：10/11/2018-4:16 PM
 *
 * @author yanzhiwen
 */
public class LeaderBoard extends Fragment {
    private int[] avatars = new int[]{R.drawable.avatar_1_raster,
            R.drawable.avatar_2_raster,
            R.drawable.avatar_3_raster};
    private String[] names = new String[]{"Steven Yan", "Jack Chen", "David Li"};
    private List<User> mUsers = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < avatars.length; i++) {
            mUsers.add(new User(names[i], avatars[i]));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        RecyclerView rv = view.findViewById(R.id.leaderboard_list);
        LeaderBoardAdapter adapter = new LeaderBoardAdapter(getActivity(), mUsers, R.layout.list_view_item);
        adapter.setItemClickListener(position -> {
            Bundle bundle = new Bundle();
            bundle.putString("userName", mUsers.get(position).username);
            Navigation.findNavController(view).navigate(R.id.action_leaderboard_to_userProfile, bundle);
        });
        rv.setAdapter(adapter);
        return view;
    }

    private static class LeaderBoardAdapter extends BaseRecycleAdapter<User> {

        public LeaderBoardAdapter(Context context, List<User> mDatas, int layoutId) {
            super(context, mDatas, layoutId);
        }

        @Override
        protected void convert(BaseViewHolder holder, User user, int position) {
            holder.setText(R.id.user_name_text, user.username)
                    .setImageResoucrce(R.id.user_avatar_image, user.avatar);
        }
    }

}
