package com.ironelder.mvpgallery.component.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.ironelder.mvpgallery.component.listener.itemOnClickListener;
import com.ironelder.mvpgallery.component.viewHolder.ImageViewHolder;
import com.ironelder.mvpgallery.data.ImageData;
import com.ironelder.mvpgallery.model.ImageViewModelInterface;
import com.ironelder.mvpgallery.view.ImageViewInferface;

import java.util.ArrayList;

public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageViewHolder> implements ImageViewModelInterface, ImageViewInferface {

    private Context context;
    private itemOnClickListener mItemOnClickListener;

    private ArrayList<ImageData> imageItems;

    public ImageRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void addItems(ArrayList<ImageData> imageItems) {
        this.imageItems = imageItems;
    }

    @Override
    public void clearItem() {
        if (imageItems != null) {
            imageItems.clear();
        }
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return imageItems != null ? imageItems.size() : 0;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(context, parent, mItemOnClickListener);
    }

    @Override
    public void setOnClickListener(itemOnClickListener clickListener) {
        this.mItemOnClickListener = clickListener;
    }

    @Override
    public ImageData getItem(int position) {
        return imageItems.get(position);
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        if (holder == null) return;
        holder.onBind(getItem(position), position);
    }
}
