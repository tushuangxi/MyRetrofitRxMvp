package com.lding.pad.myseial.libding.rerxmvp.presenter;

import com.lding.pad.myseial.libding.entity.GetListRsp;
import com.lding.pad.myseial.libding.http.manager.ApiManager;
import com.lding.pad.myseial.libding.http.manager.HttpObserver;
import com.lding.pad.myseial.libding.rerxmvp.base.BasePresenterImpl;
import com.lding.pad.myseial.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;

import java.util.Map;

public class LoginPresenterImpl extends BasePresenterImpl<interfaceUtilsAll.LoginView> implements interfaceUtilsAll.LoginPresenter {

    @Override
    public void login(Map<String, String> params) {
        ApiManager.login(params).subscribe(new HttpObserver<GetListRsp>(mView) {
            @Override
            public void onSucceed(GetListRsp getListRsp) {
                mView.loginSucceed(getListRsp);

            }

            @Override
            public void onDefeat(GetListRsp getListRsp) {
                mView.hideLoadingView();
                mView.loginFaild();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }
}
