package com.lding.pad.myseial.libding.rerxmvp.view.activity;

import android.view.View;
import com.lding.pad.myseial.R;
import com.lding.pad.myseial.libding.rerxmvp.base.BaseActivity;
import com.lding.pad.myseial.libding.widget.statebar.BaseStateBar;
import com.lding.pad.myseial.libding.widget.titlebar.BaseTitleBar;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
            findViewById(R.id.tv_test3).setOnClickListener(this);
            findViewById(R.id.tv_test4).setOnClickListener(this);
    }

    @Override
    protected View getRootView() {
        return null;
    }

    @Override
    public void onDefaultViewClick(int tag) {
        super.onDefaultViewClick(tag);
        hideDefaultView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
             case R.id.tv_test3 :
                LoginActivity.starSelf(getBaseContext(), null);
                 break;

             case R.id.tv_test4 :
 //               showErrorDefaultView("");
//                showNoDataDefaultView("11");
//                showDefaultView();
                 getDefaultViewBuild().setBtnText("自定义").setIcon(R.mipmap.ic_launcher).show();
                break;
        }
    }

}
