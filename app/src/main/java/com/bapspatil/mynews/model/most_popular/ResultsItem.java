package com.bapspatil.mynews.model.most_popular;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsItem{

	@SerializedName("per_facet")
	private String perFacet;

	@SerializedName("org_facet")
	private String orgFacet;

	@SerializedName("column")
	private String column;

	@SerializedName("section")
	private String section;

	@SerializedName("abstract")
	private String jsonMemberAbstract;

	@SerializedName("source")
	private String source;

	@SerializedName("asset_id")
	private long assetId;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private String title;

	@SerializedName("des_facet")
	private List<String> desFacet;

	@SerializedName("uri")
	private String uri;

	@SerializedName("url")
	private String url;

	@SerializedName("adx_keywords")
	private String adxKeywords;

	@SerializedName("geo_facet")
	private List<String> geoFacet;

	@SerializedName("id")
	private long id;

	@SerializedName("byline")
	private String byline;

	@SerializedName("published_date")
	private String publishedDate;

	@SerializedName("views")
	private int views;

	public void setPerFacet(String perFacet){
		this.perFacet = perFacet;
	}

	public String getPerFacet(){
		return perFacet;
	}

	public void setOrgFacet(String orgFacet){
		this.orgFacet = orgFacet;
	}

	public String getOrgFacet(){
		return orgFacet;
	}

	public void setColumn(String column){
		this.column = column;
	}

	public String getColumn(){
		return column;
	}

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setJsonMemberAbstract(String jsonMemberAbstract){
		this.jsonMemberAbstract = jsonMemberAbstract;
	}

	public String getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setAssetId(long assetId){
		this.assetId = assetId;
	}

	public long getAssetId(){
		return assetId;
	}

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDesFacet(List<String> desFacet){
		this.desFacet = desFacet;
	}

	public List<String> getDesFacet(){
		return desFacet;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAdxKeywords(String adxKeywords){
		this.adxKeywords = adxKeywords;
	}

	public String getAdxKeywords(){
		return adxKeywords;
	}

	public void setGeoFacet(List<String> geoFacet){
		this.geoFacet = geoFacet;
	}

	public List<String> getGeoFacet(){
		return geoFacet;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setByline(String byline){
		this.byline = byline;
	}

	public String getByline(){
		return byline;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
	}

	public void setViews(int views){
		this.views = views;
	}

	public int getViews(){
		return views;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"per_facet = '" + perFacet + '\'' + 
			",org_facet = '" + orgFacet + '\'' + 
			",column = '" + column + '\'' + 
			",section = '" + section + '\'' + 
			",abstract = '" + jsonMemberAbstract + '\'' + 
			",source = '" + source + '\'' + 
			",asset_id = '" + assetId + '\'' + 
			",media = '" + media + '\'' + 
			",type = '" + type + '\'' + 
			",title = '" + title + '\'' + 
			",des_facet = '" + desFacet + '\'' + 
			",uri = '" + uri + '\'' + 
			",url = '" + url + '\'' + 
			",adx_keywords = '" + adxKeywords + '\'' + 
			",geo_facet = '" + geoFacet + '\'' + 
			",id = '" + id + '\'' + 
			",byline = '" + byline + '\'' + 
			",published_date = '" + publishedDate + '\'' + 
			",views = '" + views + '\'' + 
			"}";
		}
}