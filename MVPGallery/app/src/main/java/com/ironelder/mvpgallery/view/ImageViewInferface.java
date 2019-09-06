package com.ironelder.mvpgallery.view;

import com.ironelder.mvpgallery.component.listener.itemOnClickListener;

public interface ImageViewInferface {
    void setOnClickListener(itemOnClickListener clickListener);
    void notifyAdapter();
}
