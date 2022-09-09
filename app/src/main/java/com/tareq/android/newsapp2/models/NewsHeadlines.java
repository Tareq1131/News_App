package com.tareq.android.newsapp2.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NewsHeadlines implements Serializable {

	@SerializedName("publishedAt")
	private String publishedAt;

	@SerializedName("author")
	private Object author;

	@SerializedName("urlToImage")
	private String urlToImage;

	@SerializedName("description")
	private String description;

	@SerializedName("source")
	private Source source;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("content")
	private String content;

	public void setPublishedAt(String publishedAt){
		this.publishedAt = publishedAt;
	}

	public String getPublishedAt(){
		return publishedAt;
	}

	public void setAuthor(Object author){
		this.author = author;
	}

	public Object getAuthor(){
		return author;
	}

	public void setUrlToImage(String urlToImage){
		this.urlToImage = urlToImage;
	}

	public String getUrlToImage(){
		return urlToImage;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setSource(Source source){
		this.source = source;
	}

	public Source getSource(){
		return source;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}
}