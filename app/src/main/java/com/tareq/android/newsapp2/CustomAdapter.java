package com.tareq.android.newsapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tareq.android.newsapp2.models.NewsHeadlines;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<NewsHeadlines> headlines;
    private SelectListener listener;
    private int lastPosition = -1;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.headline_list_iteams,parent,false);


        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());
               setAnimation(holder.itemView, position);


//
//        Glide.with(coContext).load("https://image.tmdb.org/t/p/w500"+
//                mList.get(position).getPublishedAt())
//                .into(holder.imageView);
        // Picasso.get().load(mList.get(position).getUrlToImage()).into(holder.imageView);
        if (headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.imageView);
        }
        holder.cardView.setOnClickListener(v -> {
          listener.OnNewsClick(headlines.get(position));
        });


    }
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.anim);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return  headlines.size();
    }
}
