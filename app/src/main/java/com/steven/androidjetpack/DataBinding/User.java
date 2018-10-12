package com.steven.androidjetpack.DataBinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.steven.androidjetpack.BR;

/**
 * Description:
 * Data：10/12/2018-5:37 PM
 *
 * @author yanzhiwen
 */
public class User extends BaseObservable {
    private String name;
    private String password;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);


    }
}
