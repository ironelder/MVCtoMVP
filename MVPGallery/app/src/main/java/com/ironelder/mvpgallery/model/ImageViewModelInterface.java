package com.ironelder.mvpgallery.model;

import com.ironelder.mvpgallery.data.ImageData;

import java.util.ArrayList;

public interface ImageViewModelInterface {
    void addItems(ArrayList<ImageData> imageItems);
    void clearItem();
    ImageData getItem(int position);
}
