package com.steven.androidjetpack.liveData;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Description:iveData是一个可被观察的数据持有者类。与常规的Observable不同，LiveData能意识到应用程序组件的生命周期变化，
 * 这意味着它能遵守Activity、Fragment、Service等组件的生命周期。这种意识确保LiveData只更新处于活跃状态的应用程序组件Observer。


 * Data：9/26/2018-4:34 PM
 *
 * @author yanzhiwen
 */
public class NameViewModel extends ViewModel {

    // Create a LiveData with a String
    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }
}