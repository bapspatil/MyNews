package com.bapspatil.mynews.model.most_popular;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MostPopularResultsItem {

	@SerializedName("section")
	private String section;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("published_date")
	private String publishedDate;

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<MediaItem> getMedia() {
		return media;
	}

	public void setMedia(List<MediaItem> media) {
		this.media = media;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "TopStoriesResultsItem{" +
				"section='" + section + '\'' +
				", media=" + media +
				", title='" + title + '\'' +
				", url='" + url + '\'' +
				", publishedDate='" + publishedDate + '\'' +
				'}';
	}
}