package com.lding.pad.myseial.libding.rerxmvp.base;

public interface  BasePresenter <V extends BaseView>{
    void attachView(V view);

    void detachView();
}
