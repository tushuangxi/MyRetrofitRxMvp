package com.lding.pad.myseial.libding.rerxmvp.base.interfaces;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.lding.pad.myseial.libding.widget.defaultview.DefaultView;
import com.lding.pad.myseial.libding.widget.statebar.BaseStateBar;
import com.lding.pad.myseial.libding.widget.titlebar.BaseTitleBar;


//接口说明：定义界面（activity或者fragment）中常用的方法以及页面公共的View 比如头部导航栏TitleBarView，状态栏StateBarView，缺省页showDefaultView
public interface BaseUiAndMethod extends DisposableManager{
    //无网络弹提示
    boolean isNetworkerConnectHint();

    //获取宿主Activity
    Activity getActivity();

    //显示隐藏加载中
    void showLoadingView();

    void showLoadingView(int Type);

    void hideLoadingView();

    //显示、隐藏缺省页
    DefaultView.DefaultViewBuild getDefaultViewBuild();

    void showDefaultView();

    void showErrorDefaultView(String text);

    void showNoDataDefaultView(String text);

    void hideDefaultView();

    boolean defaultViewIsShow();


    //提示相关方法
    void showHintAndFinish(String hint);

    void showHint(@Nullable String hintText);

    void showHint(String hintText, int color);
}
