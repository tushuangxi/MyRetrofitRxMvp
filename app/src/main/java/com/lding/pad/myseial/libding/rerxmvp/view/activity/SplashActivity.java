package com.lding.pad.myseial.libding.rerxmvp.view.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import com.lding.pad.myseial.R;
import com.lding.pad.myseial.libding.rerxmvp.base.BaseActivity;
import com.lding.pad.myseial.libding.utils.SpfsUtils;
import com.lding.pad.myseial.libding.utils.UiUtil;
import com.lding.pad.myseial.libding.utils.XPermission;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity implements View.OnClickListener {

    private String TAG = SplashActivity.class.getSimpleName();
    protected BaseActivity mBaseActivity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mBaseActivity = SplashActivity.this;

        //用于存储是否第一次进入
        boolean isFirst = SpfsUtils.readBoolean(SplashActivity.this,"isFirst", true);
        if (!isFirst){
//            goHome();
        }
        findViewById(R.id.enter_button).setOnClickListener(this);
        //1、请求单个权限
        requestPermissionsOne();
        //2、请求多个权限
        requestPermissionsMore();
    }

    private void requestPermissionsOne() {
//        doCallPhone();
//        doCamera();;
    }

    private void requestPermissionsMore() {
        sendPermission();
    }

    private void delayEntryPage() {//
/*        TimerTask task = new TimerTask() {
            @Override
            public void run() {
//                mBaseActivity.startActivity(new Intent(getActivity(), MainActivity.class));
                readyGo(MainActivity.class);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 2000);*/

        UiUtil.postDelayed(new Runnable() {
            @Override
            public void run() {
 //                mBaseActivity.startActivity(new Intent(getActivity(), MainActivity.class));
                readyGo(MainActivity.class);
            }
        }, 2000);
    }


    @Override
    protected View getRootView() {
        return null;
    }


    /**
     * 拨打电话
     */
    private void doCallPhone() {
        XPermission.requestPermissions(this, 100,new String[]{Manifest.permission.CALL_PHONE}, new XPermission.OnPermissionListener() {
            //权限申请成功时调用
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:18682555854"));
                startActivity(intent);
            }
            //权限被用户禁止时调用
            @Override
            public void onPermissionDenied() {
                //给出友好提示，并且提示启动当前应用设置页面打开权限
                XPermission.showTipsDialog(SplashActivity.this);
            }
        });
    }

    /**
     * 照相
     */
    private void doCamera() {
        XPermission.requestPermissions(this, 101, new String[]{Manifest.permission
                .CAMERA}, new XPermission.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }

            @Override
            public void onPermissionDenied() {
                XPermission.showTipsDialog(SplashActivity.this);
            }
        });
    }
    /**
     * 多个权限
     */
    private void sendPermission() {
        XPermission.requestPermissions(this, 102, permissions, new XPermission.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(getApplication(),"申请成功！",Toast.LENGTH_SHORT).show();
                delayEntryPage();
            }

            @Override
            public void onPermissionDenied() {
                XPermission.showTipsDialog(SplashActivity.this);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.enter_button:
                SpfsUtils.write(SplashActivity.this,"isFirst", false);
//                startActivity(new Intent(this,MainActivity.class));
//                mBaseActivity.startActivity(new Intent(getActivity(), MainActivity.class));
//                mBaseActivity.startActivity(new Intent(getActivity(), MainActivity.class));
                readyGo(MainActivity.class);
                finish();
                break;
        }
    }
}
