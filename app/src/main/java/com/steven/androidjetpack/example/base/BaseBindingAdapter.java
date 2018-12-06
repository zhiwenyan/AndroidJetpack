package com.steven.androidjetpack.example.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Description:
 * Data：10/24/2018-9:32 AM
 *
 * @author yanzhiwen
 */
public abstract class BaseBindingAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter<BaseBindingViewHolder> {
    private List<T> mData;
    private LayoutInflater mLayoutInflater;
    private int mLayoutId;
    private MultiTypeSupport<T> mMultiTypeSupport;
    private OnItemClickListener mOnItemClickListener;

    /**
     * @param context  Context
     * @param data     数据源
     * @param layoutId 资源布局id
     */
    public BaseBindingAdapter(Context context, List<T> data, int layoutId) {
        this.mData = data;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
    }

    /**
     * @param context          Context
     * @param data             数据源
     * @param multiTypeSupport 支持多种布局
     */
    public BaseBindingAdapter(Context context, List<T> data, MultiTypeSupport<T> multiTypeSupport) {
        this(context, data, -1);
        this.mMultiTypeSupport = multiTypeSupport;
    }

    @NonNull
    @Override
    public BaseBindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mMultiTypeSupport != null) {
            this.mLayoutId = viewType;
        }
        B binding = DataBindingUtil.inflate(mLayoutInflater, mLayoutId, parent, false);
        return new BaseBindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingViewHolder holder, int position) {
        B binding = DataBindingUtil.getBinding(holder.itemView);
        if (binding != null) {
            onBindItem(binding, mData.get(position));
            binding.executePendingBindings();
        }
        holder.itemView.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mMultiTypeSupport != null) {
            return mMultiTypeSupport.getLayoutId(mData.get(position));
        }
        return super.getItemViewType(position);
    }

    public void add(T data) {
        mData.add(data);
        notifyDataSetChanged();
    }

    public void addAll(List<T> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * @param onItemClickListener 点击事件
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    /**
     * @param binding 绑定的View
     * @param item    bean
     */
    public abstract void onBindItem(B binding, T item);
}
