package com.ironelder.mvpgallery.data.source;

import android.content.Context;
import java.util.ArrayList;
import com.ironelder.mvpgallery.data.ImageData;

public interface ImageDataSourceInterface {
    interface LoadImageCallback {
        void onImageLoaded(ArrayList<ImageData> list);
    }
    void getImages(Context context, int size, LoadImageCallback loadImageCallback);
}
