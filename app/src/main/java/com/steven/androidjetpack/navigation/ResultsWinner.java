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
 * Data：10/11/2018-4:22 PM
 *
 * @author yanzhiwen
 */
public class ResultsWinner extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results_winner, container, false);
        view.findViewById(R.id.play_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_results_winner_to_match);

            }
        });
        view.findViewById(R.id.leaderboard_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_results_winner_to_leaderboard);

            }
        });


        return view;
    }
}
