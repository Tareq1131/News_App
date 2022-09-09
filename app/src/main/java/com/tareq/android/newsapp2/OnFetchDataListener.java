package com.tareq.android.newsapp2;

import com.tareq.android.newsapp2.models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener <NewsApiResponse>{
    void onFetchData(List<NewsHeadlines> list,String message);
    void onError(String message);

}
