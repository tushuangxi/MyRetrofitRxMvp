package com.lding.pad.myseial.libding.http.manager;

import com.lding.pad.myseial.libding.entity.GetListRsp;
import com.lding.pad.myseial.libding.http.ApiService;
import java.util.Map;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiManager {

    private static <T> Observable<T> subscribeOn(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static ApiService getJavaApi() {
        return HttpUtil.getInstance().getHttpApi();
    }

    /***************************************业务逻辑接口**************************************/
        /*获取首页数据*/
//    public static Observable<TDataBean<GetListRsp>> getIndexData() {
//        Observable<TDataBean<GetListRsp>> observable = getJavaApi().getIndexData();
//        return subscribeOn(observable);
//    }
    /*获取首页数据*/
    public static Observable<GetListRsp> getIndexData() {
        Observable<GetListRsp> observable = getJavaApi().getIndexData();
        return subscribeOn(observable);
    }

    /*获取首页数据*/
    public static Observable<GetListRsp> login(Map<String, String> params) {
//        JsonObject data = new JsonObject();
//        data.addProperty("mobile", username);
//        data.addProperty("password", pwd);
//        data.addProperty("device_token", DeviceUtils.getDeviceId());
        Observable<GetListRsp> observable = getJavaApi().login(params);
        return subscribeOn(observable);
    }
}
