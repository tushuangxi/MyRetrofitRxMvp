package com.lding.pad.myseial.libding.rerxmvp.base;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {

    public V mView;

    @Override
    public void attachView(V view) {
        mView=view;
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
