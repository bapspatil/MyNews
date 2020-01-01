package com.bapspatil.mynews.api;
/*
 ** Created by Bapusaheb Patil {@link https://bapspatil.com}
 */

import com.bapspatil.mynews.model.article_search.ArticleSearchResponse;
import com.bapspatil.mynews.model.most_popular.MostPopularResponse;
import com.bapspatil.mynews.model.top_stories.TopStoriesResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TheNewYorkTimesService {

    // Base URL for The New York Times API
    String BASE_URL = "https://api.nytimes.com/svc/";

    // Retrofit instance
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // Top Stories API
    @GET("topstories/v2/{section}.json")
    Call<TopStoriesResponse> getTopStories(
            @Path("section") String SECTION,
            @Query("api-key") String API_KEY
    );

    // Most Popular API
    @GET("mostpopular/v2/viewed/{period}.json")
    Call<MostPopularResponse> getMostPopular(
            @Path("period") int PERIOD,
            @Query("api-key") String API_KEY
    );

    // Article Search API
    @GET("search/v2/articlesearch.json")
    Call<ArticleSearchResponse> getArticleSearch(
            @Query("q") String QUERY,
            @Query("fq") String FILTER,
            @Query("begin_date") String BEGIN_DATE,
            @Query("end_date") String END_DATE,
            @Query("api-key") String API_KEY
    );
}
