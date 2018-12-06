package com.steven.androidjetpack.DataBinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steven.androidjetpack.BR;
import com.steven.androidjetpack.R;

import java.util.List;

/**
 * Description:
 * Data：10/12/2018-4:20 PM
 *
 * @author yanzhiwen
 */
public class FoodListAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<Food> mFoods;

    public FoodListAdapter(Context context, List<Food> foods) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mFoods = foods;
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding view = DataBindingUtil.inflate(mLayoutInflater, R.layout.food_item, parent, false);
        return new BindingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        Food food = mFoods.get(position);
        holder.getBinding().setVariable(BR.food, food);
        //及时刷新
        holder.getBinding().executePendingBindings();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mFoods.size();
    }

    public void addAll(List<Food> foods) {
        foods.clear();
        mFoods.addAll(foods);
        notifyDataSetChanged();
    }

    public void add(Food food) {
        mFoods.add(0, food);
        notifyItemInserted(0);
    }

    public void remove() {
        mFoods.remove(mFoods.size() - 1);
        notifyItemRemoved(mFoods.size() - 1);
    }
}
