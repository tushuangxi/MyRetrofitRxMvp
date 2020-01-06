package com.lding.pad.myseial.libding.entity;

/**
 * 作者：wl on 2017/9/21 15:29
 * 邮箱：wangl@ixinyongjia.com
 */
public interface IBaseResult {
    boolean isSucceed();

    String getError_msg();

    String getError_code();

}
