package com.lding.pad.myseial.libding.rerxmvp.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.lding.pad.myseial.R;
import com.lding.pad.myseial.libding.entity.GetListRsp;
import com.lding.pad.myseial.libding.http.ServiceMapParams;
import com.lding.pad.myseial.libding.rerxmvp.base.MVPBaseActivity;
import com.lding.pad.myseial.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.lding.pad.myseial.libding.rerxmvp.presenter.LoginPresenterImpl;


public class LoginActivity extends MVPBaseActivity<interfaceUtilsAll.LoginView, LoginPresenterImpl> implements interfaceUtilsAll.LoginView {
    EditText et_account;
    EditText et_pwd;
    TextView tv_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected View getRootView() {
        return null;
    }

    private void initview() {
        et_account = (EditText) findViewById(R.id.et_acount);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });

    }

    private void submitData() {
//        if (checkData() && isNetworkerConnectHint()) {
//            String account = et_account.getText().toString().trim();
//            String pwd = et_pwd.getText().toString().trim();
//        }

        showLoadingView();
        mPresenter.login(ServiceMapParams.getGetListRspMapParams());
    }

    private boolean checkData() {
        if (TextUtils.isEmpty(et_account.getText().toString().trim())) {
            return false;
        } else if (TextUtils.isEmpty(et_pwd.getText().toString().trim())) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void loginSucceed(GetListRsp getListRsp) {
        showHint("请求成功");
    }

    @Override
    public void loginFaild() {
        showHint("请求失败");
    }


    public static void starSelf(Context context, String dataString) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("data", dataString);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
