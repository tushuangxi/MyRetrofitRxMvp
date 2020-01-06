//package com.lding.pad.myseial.libding.utils.imageloader;
//
//import android.net.Uri;
//import com.bumptech.glide.Glide;
//import com.lding.pad.myseial.libding.utils.UiUtil;
//import java.io.File;
//
//public class BaseImageLoader {
//
//    public static GlideConfing load(String path) {
//        return new GlideConfing(Glide.with(UiUtil.getContext()).load(path));
//    }
//
//    public static GlideConfing load(File file) {
//        return new GlideConfing(Glide.with(UiUtil.getContext()).load(file));
//    }
//
//    public static GlideConfing load(Uri uri) {
//        return new GlideConfing(Glide.with(UiUtil.getContext()).load(uri));
//    }
//
//    public static GlideConfing load(int rid) {
//        return new GlideConfing(Glide.with(UiUtil.getContext()).load(rid));
//    }
//}
