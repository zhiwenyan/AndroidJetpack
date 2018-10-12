package com.steven.androidjetpack.DataBinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.steven.androidjetpack.BR;


/**
 * Description:
 * Data：9/26/2018-5:00 PM
 *
 * @author yanzhiwen
 */
public class Food extends BaseObservable {
    private String name;
    private double price;
    private String url;
    public Food() {
    }

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        //通知属性改变
        notifyPropertyChanged(BR.price);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
