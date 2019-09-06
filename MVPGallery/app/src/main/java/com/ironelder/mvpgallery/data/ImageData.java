package com.ironelder.mvpgallery.data;

public class ImageData {
    private int imageResource;
    private String imageTitle;

    public ImageData(int resource, String title) {
        this.imageResource = resource;
        this.imageTitle = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getImageTitle() {
        return imageTitle;
    }
}
