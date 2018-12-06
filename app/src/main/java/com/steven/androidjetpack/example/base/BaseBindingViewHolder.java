package com.steven.androidjetpack.example.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Description:
 * Data：10/24/2018-9:32 AM
 *
 * @author yanzhiwen
 */
public class BaseBindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T mBinding;

    public BaseBindingViewHolder(T binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    public T getBinding() {
        return mBinding;
    }
}
