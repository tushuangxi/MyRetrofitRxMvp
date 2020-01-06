package com.lding.pad.myseial.libding.rerxmvp.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.lding.pad.myseial.R;
import com.lding.pad.myseial.libding.rerxmvp.base.component.BasePermissionsAndStackActivity;
import com.lding.pad.myseial.libding.rerxmvp.base.interfaces.OnClickDefaultBtn;
import com.lding.pad.myseial.libding.utils.KeyboardHelper;
import com.lding.pad.myseial.libding.utils.NetworkUtil;
import com.lding.pad.myseial.libding.widget.defaultview.DefaultView;
import com.lding.pad.myseial.libding.widget.loading.LoadingActivityDialog;
import com.lding.pad.myseial.libding.widget.statebar.BaseStateBar;
import com.lding.pad.myseial.libding.widget.statebar.StateBar;
import com.lding.pad.myseial.libding.widget.titlebar.BaseTitleBar;
import com.lding.pad.myseial.libding.widget.titlebar.TitleBar;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public abstract class BaseActivity extends BasePermissionsAndStackActivity implements BaseView, OnClickDefaultBtn {

    //根容器布局
    private RelativeLayout mContainer;

    /*缺省页*/
    private DefaultView defaultView;
    /*加载框子*/
    private LoadingActivityDialog loadDialogView;

    /*RxJava的事件解绑管理类？*/
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        initView();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract View getRootView();


    @Override
    public void setContentView(View view) {
        super.setContentView(initContentView(view));
    }

    protected View initContentView(View view) {
        mContainer = new RelativeLayout(this);
        mContainer.addView(view, getLayoutParams());

        return mContainer;
    }

    private RelativeLayout.LayoutParams getLayoutParams() {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        if (titleBar != null) {
//            lp.addRule(RelativeLayout.BELOW, titleBar.getId());
//        } else if (stateBar.isEnabled()) {
//            lp.addRule(RelativeLayout.BELOW, stateBar.getId());
//        }
        return lp;
    }


    /*********************LoadingView相关方法***********************/

    private void initLoadingView() {

        if (loadDialogView == null ) {
            loadDialogView = LoadingActivityDialog.createDialog(this);
            loadDialogView.show();
        }
    }


    protected boolean setStateBarPattern() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            return true;
        } else {
            return false;
        }
    }

    /*********************缺省页DefaultView相关方法***********************/

    private void initDefaultView() {
        if (defaultView == null) {
            defaultView = new DefaultView();
            defaultView.setClickListener(this);
            if ( loadDialogView != null) {
                mContainer.addView(defaultView.getRootView(), mContainer.getChildCount() - 1, getLayoutParams());
            } else {
                mContainer.addView(defaultView.getRootView(), getLayoutParams());
            }
        }
    }

    /*********************实现接口的方法**********************/

    @Override
    public void onDefaultViewClick(int tag) {

    }

    @Override
    public boolean isNetworkerConnectHint() {
        boolean networkerConnect = NetworkUtil.isNetworkerConnect();
        if (!networkerConnect) {
            showHint(getString(R.string.network_error));
        }
        return networkerConnect;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showLoadingView() {
        initLoadingView();
    }

    @Override
    public void showLoadingView(int type) {
        if (loadDialogView == null) {
            loadDialogView = LoadingActivityDialog.createDialog(this);
            loadDialogView.show();
        }
    }

    @Override
    public void hideLoadingView() {
        if (loadDialogView != null ) {
            loadDialogView.dismiss();
        }
    }

    @Override
    public void showDefaultView() {
        initDefaultView();
        defaultView.show();
    }

    @Override
    public void showErrorDefaultView(@Nullable String error) {
        initDefaultView();
        defaultView.setErrorData(error);
    }

    @Override
    public void showNoDataDefaultView(String text) {
        initDefaultView();
        defaultView.setResultData(text);
    }

    @Override
    public void hideDefaultView() {
        if (defaultView != null) {
            defaultView.hide();
        }
    }

    @Override
    public DefaultView.DefaultViewBuild getDefaultViewBuild() {
        initDefaultView();
        return defaultView.getBuild();
    }

    @Override
    public boolean defaultViewIsShow() {
        if (defaultView == null) {
            return false;
        } else {
            return defaultView.isShow();
        }
    }


    @Override
    public void showHintAndFinish(String hint) {

    }

    @Override
    public void showHint(@Nullable String hintText) {
        if (TextUtils.isEmpty(hintText)) {
        } else {
            Toast.makeText(this, hintText, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showHint(String hintText, int color) {

    }


    /*****************RxJava相关***************************************/
    @Override
    public void addDisposable(Disposable observer) {
        compositeDisposable.add(observer);
    }

    @Override
    public void removeDisposable(Disposable observer) {
        compositeDisposable.remove(observer);
    }

    @Override
    public void dispose() {
        compositeDisposable.dispose();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispose();
    }


    /**
     * @param clazz
     * @param bundle 跳转页面
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void readyGo(Class<?> clazz) {
        readyGo(clazz, null);
    }
    /**
     * @param clazz  目标Activity
     * @param bundle 数据
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        readyGo(clazz, bundle);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     * @param bundle      数据
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
}
