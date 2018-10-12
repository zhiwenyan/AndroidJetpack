package com.steven.androidjetpack.DataBinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.databinding.ActivityFoodListBinding;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {
    private ActivityFoodListBinding mBinding;
    private FoodListAdapter foodListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_food_list);
        mBinding.rvFood.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        foodListAdapter = new FoodListAdapter(this, addFoods());
        mBinding.rvFood.setAdapter(foodListAdapter);
    }

    private List<Food> addFoods() {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Food food = new Food();
            food.setName("中式面包");
            food.setPrice(i);
//            food.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=15393" +
//                    "45604933&di=1bd033fdd1d65d68c088c287c22005a5&imgtype=0&src=http%3A%2F%2Fopgm6di" +
//                    "oh.bkt.clouddn.com%2F800W_800H_15114081718751.jpg");
            foods.add(food);
        }
        return foods;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.food, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Food food = new Food();
                food.setName("中式面包");
                food.setPrice(8.8);
//                food.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=15393" +
//                        "45604933&di=1bd033fdd1d65d68c088c287c22005a5&imgtype=0&src=http%3A%2F%2Fopgm6di" +
//                        "oh.bkt.clouddn.com%2F800W_800H_15114081718751.jpg");
                foodListAdapter.add(food);
                mBinding.rvFood.smoothScrollToPosition(0);
                break;
            case R.id.remove:
                foodListAdapter.remove();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
