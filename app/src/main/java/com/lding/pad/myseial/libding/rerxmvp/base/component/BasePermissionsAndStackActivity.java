package com.lding.pad.myseial.libding.rerxmvp.base.component;

import android.Manifest;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.lding.pad.myseial.libding.utils.XPermission;
import com.lding.pad.myseial.libding.widget.LibLoader;

public  class BasePermissionsAndStackActivity extends AppCompatActivity  {
    private boolean isInitFocus = false;  //记录是否已经初始化获得了焦点，PopupWindow必须在Activity获取焦点后才能显示。
    private boolean isDestroyed = false;    //记录activity是否已经被销毁了
    /*权限相关*/
    public String[] permissions = new String[]{Manifest.permission.CALL_PHONE,//打电话
            Manifest.permission.WRITE_EXTERNAL_STORAGE,//写内存卡的权限
            Manifest.permission.READ_EXTERNAL_STORAGE,//读内存卡的权限
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
            Manifest.permission.SEND_SMS,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LibLoader.addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LibLoader.removeActivity(this);
        isDestroyed = true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            isInitFocus = true;
        }
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public boolean isInitFocus() {
        return isInitFocus;
    }

    /**
     * Android M 全局权限申请回调
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        XPermission.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
