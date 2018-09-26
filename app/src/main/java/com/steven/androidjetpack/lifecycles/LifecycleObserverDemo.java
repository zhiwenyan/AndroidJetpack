package com.steven.androidjetpack.lifecycles;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Description:Lifecycle
 * 是 Android Architecture Components 的一个组件，用于将系统组件（Activity、Fragment等等）的生命周期分离到 Lifecycle 类，
 * Lifecycle 允许其他类作为观察者，观察组件生命周期的变化。Lifecycle 用起来很简单，首先声明一个 LifecycleObserver 对象.
 * 用 @OnLifecycleEvent 注解声明生命周期事件回调的方法：
 * Data：9/26/2018-3:35 PM
 *
 * @author yanzhiwen
 */
public class LifecycleObserverDemo implements LifecycleObserver {

    private static final String TAG = LifecycleObserverDemo.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.d(TAG, "onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Log.d(TAG, "onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.d(TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.d(TAG, "onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.d(TAG, "onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

}
