package com.lding.pad.myseial.libding.widget.statebar;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;

import com.lding.pad.myseial.R;
import com.lding.pad.myseial.libding.utils.UiUtil;

public class StateBar implements BaseStateBar {
    private boolean isEnabled;

    private View stateBar;

    public StateBar(boolean isEnabled) {
        this.isEnabled = isEnabled;
        if (isEnabled) {
            initView();
        }
    }

    private void initView() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, UiUtil.getStateBarHeight());
        stateBar = new View(UiUtil.getContext());

        stateBar.setLayoutParams(params);
        stateBar.setBackgroundColor(UiUtil.getColor(R.color.black));
        stateBar.setId(getId());
    }

    public View getView() {
        return stateBar;
    }

    @Override
    public int getId() {
        return R.id.id_state_bar;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void show() {
        if (isEnabled && stateBar.getVisibility() != View.VISIBLE) {
            stateBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hide() {
        if (isEnabled && stateBar.getVisibility() != View.GONE) {
            stateBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void setBackgroundColor(int color) {
        if (isEnabled) {
            stateBar.setBackgroundColor(UiUtil.getColor(color));
        }
    }

    @Override
    public void setBackgroundDrawable(@DrawableRes int resId) {
        if (isEnabled) {
            stateBar.setBackgroundResource(resId);
        }
    }
}
