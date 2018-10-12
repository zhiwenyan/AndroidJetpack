package com.steven.androidjetpack;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.steven.androidjetpack.DataBinding.FoodActivity;
import com.steven.androidjetpack.DataBinding.FoodListActivity;
import com.steven.androidjetpack.DataBinding.TwoWayActivity;
import com.steven.androidjetpack.ViewModel.UserViewModel;
import com.steven.androidjetpack.lifecycles.LifecycleObserverDemo;
import com.steven.androidjetpack.liveData.NameViewModel;
import com.steven.androidjetpack.navigation.NavigationActivity;
import com.steven.androidjetpack.room.User;
import com.steven.androidjetpack.room.UserInfoActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private NameViewModel mViewModel;
    private TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.tv_name);
        findViewById(R.id.btn_food).setOnClickListener(this);
        findViewById(R.id.btn_update).setOnClickListener(this);
        findViewById(R.id.btn_room).setOnClickListener(this);
        findViewById(R.id.btn_navigation).setOnClickListener(this);
        findViewById(R.id.btn_list_foods).setOnClickListener(this);
        findViewById(R.id.btn_two_way).setOnClickListener(this);
        getLifecycle()
                .addObserver(new LifecycleObserverDemo());


        //获取ViewModel
        mViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                mName.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mViewModel.getCurrentName().observe(this, nameObserver);


        UserViewModel model = ViewModelProviders.of(this).get(UserViewModel.class);
        model.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                String anotherName = "Steven Yan";
                mViewModel.getCurrentName().setValue(anotherName);
                break;
            case R.id.btn_food:
                startActivity(new Intent(this, FoodActivity.class));
                break;
            case R.id.btn_room:
                startActivity(new Intent(this, UserInfoActivity.class));
                break;
            case R.id.btn_navigation:
                startActivity(new Intent(this, NavigationActivity.class));
                break;
            case R.id.btn_list_foods:
                startActivity(new Intent(this, FoodListActivity.class));
                break;
            case R.id.btn_two_way:
                startActivity(new Intent(this, TwoWayActivity.class));

                break;
        }
    }
}
