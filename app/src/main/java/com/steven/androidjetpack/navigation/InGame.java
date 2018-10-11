package com.steven.androidjetpack.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steven.androidjetpack.R;

import androidx.navigation.Navigation;

/**
 * Description:
 * Data：10/11/2018-4:20 PM
 *
 * @author yanzhiwen
 */
public class InGame extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_in_game, container, false);
        view.findViewById(R.id.checkBox3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_in_game_to_resultsWinner);
            }
        });
        return view;

    }
}
