package com.steven.androidjetpack.DataBinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.databinding.ActivityFoodBinding;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFoodBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_food);
        Food food = new Food();
        food.setName("面包");
        food.setPrice(2.0);
        //Bind UI
        binding.setFood(food);


        binding.btnBuy.setOnClickListener(v -> food.setPrice(3.0));


    }
}
