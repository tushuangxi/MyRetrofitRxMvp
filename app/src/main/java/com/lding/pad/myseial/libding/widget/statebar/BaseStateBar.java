package com.lding.pad.myseial.libding.widget.statebar;

import android.view.View;

import androidx.annotation.DrawableRes;


public interface BaseStateBar {
    void show();

    void hide();

    void setBackgroundColor(int color);

    void setBackgroundDrawable(@DrawableRes int resId);

    View getView();

    int getId();

    boolean isEnabled();
}
