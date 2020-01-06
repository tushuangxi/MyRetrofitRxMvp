package com.lding.pad.myseial.libding.http;

import com.lding.pad.myseial.libding.entity.GetListRsp;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface ApiService {

    /*APP主域名*/
    String APP_HOST = "http://api.zhuishushenqi.com";//正式接口

    /*************************业务接口*****************************************/
    /*首页*/
    String FUNCTION_INDEX = "/cats/lv2/statistics/";
    /*登陆*/
    String FUNCTION_LOGIN =  "/cats/lv2/statistics/";

    /*获取首页数据*/
    @GET(FUNCTION_INDEX)
    Observable<GetListRsp> getIndexData();

//    /*登录*/
//    @POST(FUNCTION_LOGIN)
//    Observable<TDataBean<UserInfo>> login(@Body JsonObject object);


    /*登录  GetListRsp  */
    @GET(FUNCTION_LOGIN)
    Observable<GetListRsp> login(@QueryMap Map<String, String> params);
}
