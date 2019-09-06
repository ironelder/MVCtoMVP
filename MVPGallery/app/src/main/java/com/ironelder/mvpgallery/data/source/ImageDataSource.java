package com.ironelder.mvpgallery.data.source;

import android.content.Context;

import com.ironelder.mvpgallery.data.ImageData;

import java.util.ArrayList;

public class ImageDataSource implements ImageDataSourceInterface{
    @Override
    public void getImages(Context context, int size, LoadImageCallback loadImageCallback) {
        ArrayList<ImageData> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            final int random = (int) (Math.random() * 15);
            final String name = String.format("ironelder%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageData(resource, name));
        }

        if (loadImageCallback != null) {
            loadImageCallback.onImageLoaded(items);
        }
    }
}
