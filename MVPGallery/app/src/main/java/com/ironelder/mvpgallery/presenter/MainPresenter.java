package com.ironelder.mvpgallery.presenter;

import android.content.Context;

import com.ironelder.mvpgallery.component.listener.itemOnClickListener;
import com.ironelder.mvpgallery.data.ImageData;
import com.ironelder.mvpgallery.data.source.ImageDataSourceStorage;
import com.ironelder.mvpgallery.model.ImageViewModelInterface;
import com.ironelder.mvpgallery.view.BaseView;
import com.ironelder.mvpgallery.view.ImageViewInferface;


public class MainPresenter implements BasePresenter, itemOnClickListener {

    private BaseView view;

    private ImageViewModelInterface mAdapterModel;
    private ImageViewInferface mAdapterView;

    private ImageDataSourceStorage mImageData;

    @Override
    public void attachView(BaseView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setImageData(ImageDataSourceStorage imageData) {
        this.mImageData = imageData;
    }

    @Override
    public void loadItems(Context context, final boolean isClear) {
        mImageData.getImages(context, 10, list -> {
            if (list != null) {
                if (isClear) {
                    mAdapterModel.clearItem();
                }
                mAdapterModel.addItems(list);
                mAdapterView.notifyAdapter();
            }
        });


    }

    @Override
    public void setImageAdapterModel(ImageViewModelInterface adapterModel) {
        this.mAdapterModel = adapterModel;
    }

    @Override
    public void setImageAdapterView(ImageViewInferface adapterView) {
        this.mAdapterView = adapterView;
        this.mAdapterView.setOnClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        ImageData imageItem = mAdapterModel.getItem(position);
        view.showImageTitle(imageItem.getImageTitle());
    }
}