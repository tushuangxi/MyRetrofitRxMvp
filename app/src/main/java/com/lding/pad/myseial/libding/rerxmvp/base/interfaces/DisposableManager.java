package com.lding.pad.myseial.libding.rerxmvp.base.interfaces;

import io.reactivex.disposables.Disposable;

//类说明：Rxjava的Disposable用来取消事件，这里的作用是放入activity中，页面关闭时取消网络请求
public interface DisposableManager {
    void addDisposable(Disposable observer);
    void removeDisposable(Disposable observer);
    void dispose();
}
