package com.tareq.android.newsapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tareq.android.newsapp2.models.NewsHeadlines;

import javax.xml.transform.Result;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView txt_title,txt_author,txt_time,txt_detail,txt_content;
    ImageView img_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_title = findViewById(R.id.text_details_title);
        txt_author = findViewById(R.id.text_details_author);
        txt_time = findViewById(R.id.text_details_time);
        txt_detail = findViewById(R.id.text_details_detail);
        txt_content = findViewById(R.id.text_details_contain);
        img_news = findViewById(R.id.img_details_news);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getContent());
        txt_content.setText(headlines.getDescription());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
    }
}