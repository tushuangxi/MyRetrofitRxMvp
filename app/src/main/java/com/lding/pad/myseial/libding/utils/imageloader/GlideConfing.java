//package com.lding.pad.myseial.libding.utils.imageloader;
//
//import android.graphics.drawable.Drawable;
//import android.widget.ImageView;
//import com.bumptech.glide.RequestBuilder;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.bumptech.glide.request.RequestOptions;
//import com.bumptech.glide.request.target.Target;
//import com.lding.pad.myseial.libding.utils.UiUtil;
//
//public class GlideConfing {
//    private RequestBuilder<Drawable> requestBuilder;
//    private RequestOptions requestOptions;
//
//    public GlideConfing(RequestBuilder<Drawable> builder) {
//        requestBuilder = builder;
//        requestOptions = new RequestOptions();
//    }
//
//    public GlideConfing placeholder(int resourceId) {
//        requestOptions.placeholder(resourceId);
//
//        return this;
//    }
//
//    public GlideConfing error(int resourceId) {
//        requestOptions.error(resourceId);
//
//        return this;
//    }
//
//
//    public GlideConfing skipMemoryCache(boolean noMemoryCach) {
//        requestOptions.skipMemoryCache(noMemoryCach);
//
//        return this;
//    }
//
//    public GlideConfing skipDiskCache(DiskCacheStrategy valuse) {
//        requestOptions.diskCacheStrategy(valuse);
//
//        return this;
//    }
//
//
//    public GlideConfing thumbnail(float sizeMultiplier) {
//        requestBuilder.thumbnail(sizeMultiplier);
//
//        return this;
//    }
//
//    public GlideConfing setCircleTransform() {
//        requestOptions.transform(new GlideCircleTransform(UiUtil.getContext()));
//        return this;
//    }
//
//
//    public void into(ImageView imageView) {
//        requestBuilder.apply(requestOptions);
//        requestBuilder.into(imageView);
//    }
//
//    public void into(ImageView imageView, RequestOptions options) {
//        requestBuilder.apply(options);
//        requestBuilder.into(imageView);
//    }
//
//    public void into(Target target) {
//        requestBuilder.apply(requestOptions);
//        requestBuilder.into(target);
//    }
//
//
//}
