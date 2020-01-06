package com.lding.pad.myseial.libding.rerxmvp.interfaceUtils;

import com.lding.pad.myseial.libding.entity.GetListRsp;
import com.lding.pad.myseial.libding.rerxmvp.base.BasePresenter;
import com.lding.pad.myseial.libding.rerxmvp.base.BaseView;
import java.util.Map;

public class interfaceUtilsAll {


    //Login
    public interface LoginView extends BaseView {
        void loginSucceed(GetListRsp getListRsp);

        void loginFaild();
    }

    public interface LoginPresenter extends BasePresenter<LoginView> {
        void login(Map<String, String> params);

    }
}
