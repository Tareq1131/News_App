package com.tareq.android.newsapp2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView text_title,text_source;
    CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        text_title = itemView.findViewById(R.id.text_title);
        text_source = itemView.findViewById(R.id.text_source);
        imageView = itemView.findViewById(R.id.img_header);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
