package com.steven.androidjetpack.DataBinding;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.steven.androidjetpack.R;
import com.steven.androidjetpack.databinding.ActivityTwoWayBinding;


/**
 * DataBinding 双向绑定
 */
public class TwoWayActivity extends AppCompatActivity {
    private ActivityTwoWayBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);
        User user = new User();
        user.setName("Steven");
        user.setPassword("123456");
        mBinding.setUser(user);
        mBinding.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {

            }
        });

        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup viewGroup=(ViewGroup)binding.getRoot();
                //动画
                TransitionManager.beginDelayedTransition(viewGroup);
                return true;
            }
        });


        mBinding.login.setOnClickListener(v -> {


        });
    }
}
