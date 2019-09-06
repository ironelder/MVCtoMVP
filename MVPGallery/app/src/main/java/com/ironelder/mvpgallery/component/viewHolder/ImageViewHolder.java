package com.ironelder.mvpgallery.component.viewHolder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;

import com.ironelder.mvpgallery.R;
import com.ironelder.mvpgallery.component.listener.itemOnClickListener;
import com.ironelder.mvpgallery.data.ImageData;
import com.ironelder.mvpgallery.utils.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private Context context;

    private itemOnClickListener onItemClickListener;

    @BindView(R.id.image_view)
    ImageView imageView;

    public ImageViewHolder(Context context, ViewGroup parent, itemOnClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.image_data_view, parent, false));
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(ImageData item, final int position) {
        itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
        new ImageLoader(context, imageView).execute(item.getImageResource());
    }
}
