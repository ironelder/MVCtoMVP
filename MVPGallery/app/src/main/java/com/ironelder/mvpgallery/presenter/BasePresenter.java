package com.ironelder.mvpgallery.presenter;

import android.content.Context;

import com.ironelder.mvpgallery.data.source.ImageDataSourceStorage;
import com.ironelder.mvpgallery.model.ImageViewModelInterface;
import com.ironelder.mvpgallery.view.BaseView;
import com.ironelder.mvpgallery.view.ImageViewInferface;

public interface BasePresenter {
    void attachView(BaseView view);
    void setImageAdapterModel(ImageViewModelInterface adapterModel);
    void setImageAdapterView(ImageViewInferface adapterView);
    void detachView();
    void setImageData(ImageDataSourceStorage imageData);
    void loadItems(Context context, boolean isClear);
}
