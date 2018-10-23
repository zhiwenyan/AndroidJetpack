package com.steven.androidjetpack.DataBinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

import com.steven.androidjetpack.BR;


/**
 * Description:BaseObservable 双向绑定 数据及时更新
 * Data：9/26/2018-5:00 PM
 *
 * @author yanzhiwen
 */
public class Food extends BaseObservable {
    private String name;
    private double price;
    private String url;
    private ObservableBoolean isHot=new ObservableBoolean();

    public Food() {
        isHot.set(false);

    }

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
        isHot.set(false);
    }


    public ObservableBoolean getIsHot() {
        return isHot;
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

    public void setHot(boolean hot) {
        isHot.set(hot);
    }
}
