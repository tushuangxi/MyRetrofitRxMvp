package com.lding.pad.myseial.libding.entity;

/**
 * 作者：wl on 2017/9/21 15:36
 * 邮箱：wangl@ixinyongjia.com
 */
public class BaseResult implements IBaseResult{

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public boolean isSucceed() {
        return code==0?true:false;
    }

    @Override
    public String getError_msg() {
        return msg;
    }

    @Override
    public String getError_code() {
        return String.valueOf(code);
    }
}
