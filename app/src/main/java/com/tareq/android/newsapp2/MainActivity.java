package com.tareq.android.newsapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.tareq.android.newsapp2.models.NewsApiResponse;
import com.tareq.android.newsapp2.models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener, View.OnClickListener {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    Context context;
    private ProgressDialog dialog;
    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7;
  SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching news articles of"+query);
                dialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listener,"general",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching news articles..");
        dialog.show();
        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);
        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);
        btn_4 = findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);
        btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);
        btn_6 = findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);
        btn_7 = findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,"general",null);


    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            if (list.isEmpty()){
                Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
            }
            else {
                showNews(list);
                dialog.dismiss();
            }

        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "An Error Occured!!", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadlines> list) {

        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this,list,this);
        recyclerView.setAdapter(adapter);

    }



    @Override
    public void OnNewsClick(NewsHeadlines headlines) {
      startActivity(new Intent(MainActivity.this,DetailsActivity.class)
      .putExtra("data", headlines));
    }

    @Override
    public void onClick(View v) {
      Button button = (Button) v;
      String  category =button.getText().toString();
      dialog.setTitle("Fetching New Article Of" +category);
       dialog.show();
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,category,null);
    }
}