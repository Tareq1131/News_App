package com.tareq.android.newsapp2.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NewsApiResponse implements Serializable {

	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("articles")
	private List<NewsHeadlines> articles;

	@SerializedName("status")
	private String status;

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public void setArticles(List<NewsHeadlines> articles){
		this.articles = articles;
	}

	public List<NewsHeadlines> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}