package com.ironelder.mvpgallery.data.source;

import android.content.Context;

import com.ironelder.mvpgallery.data.ImageData;

import java.util.ArrayList;

public class ImageDataSourceStorage implements ImageDataSourceInterface{


    private static ImageDataSourceStorage mImageDataSourceStorage;

    public static ImageDataSourceStorage getInstance() {
        if (mImageDataSourceStorage == null) {
            mImageDataSourceStorage = new ImageDataSourceStorage();
        }
        return mImageDataSourceStorage;
    }

    private ImageDataSource mImageDataSource;

    private ImageDataSourceStorage() {
        mImageDataSource = new ImageDataSource();
    }

    @Override
    public void getImages(Context context, int size, final LoadImageCallback loadImageCallback) {
        mImageDataSource.getImages(context, size, new LoadImageCallback() {
            @Override
            public void onImageLoaded(ArrayList<ImageData> list) {
                if (loadImageCallback != null) {
                    loadImageCallback.onImageLoaded(list);
                }
            }
        });
    }
}
