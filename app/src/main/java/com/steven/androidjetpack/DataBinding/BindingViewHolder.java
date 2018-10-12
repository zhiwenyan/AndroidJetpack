package com.steven.androidjetpack.DataBinding;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Description:
 * Data：10/12/2018-4:18 PM
 *
 * @author yanzhiwen
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T mBinding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding=binding;
    }

    public T getBinding() {
        return mBinding;
    }
}
