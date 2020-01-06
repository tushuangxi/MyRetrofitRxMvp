package com.lding.pad.myseial.libding.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class RecycleViewBottomDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public RecycleViewBottomDecoration(int space) {
        //this.space = XYJUiUtil.dip2px(space);
        this.space =space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

//        if (parent.getChildPosition(view) != 0){
//            outRect.top = space;
//        }else{
//            outRect.top = 0;
//        }
        outRect.bottom = space;
    }
}
