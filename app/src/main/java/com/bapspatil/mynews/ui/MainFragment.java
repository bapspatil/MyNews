package com.bapspatil.mynews.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bapspatil.mynews.BuildConfig;
import com.bapspatil.mynews.R;
import com.bapspatil.mynews.adapter.MostPopularAdapter;
import com.bapspatil.mynews.adapter.TopStoriesAdapter;
import com.bapspatil.mynews.api.TheNewYorkTimesService;
import com.bapspatil.mynews.model.most_popular.MostPopularResponse;
import com.bapspatil.mynews.model.most_popular.MostPopularResultsItem;
import com.bapspatil.mynews.model.top_stories.TopStoriesResultsItem;
import com.bapspatil.mynews.model.top_stories.TopStoriesResponse;
import com.bapspatil.mynews.util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private RecyclerView newsRecyclerView;

    private TopStoriesAdapter topStoriesAdapter;
    private MostPopularAdapter mostPopularAdapter;
    private List<TopStoriesResultsItem> topStoriesResultsItems = new ArrayList<>();
    private List<MostPopularResultsItem> mostPopularResultsItems = new ArrayList<>();
    private TheNewYorkTimesService theNewYorkTimesService = TheNewYorkTimesService.retrofit.create(TheNewYorkTimesService.class);


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String sectionName) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_SECTION_NAME, sectionName);
        MainFragment mainFragment = new MainFragment();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        topStoriesAdapter = new TopStoriesAdapter(topStoriesResultsItems);
        mostPopularAdapter = new MostPopularAdapter(mostPopularResultsItems);

        newsRecyclerView = view.findViewById(R.id.rv_news);
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        if (getArguments() != null) {
            String selectedSection = getArguments().getString(Constants.KEY_SECTION_NAME, Constants.SECTIONS[0]);
            switch (selectedSection) {
                case "Most Popular":
                    newsRecyclerView.setAdapter(mostPopularAdapter);
                    callMostPopular();
                    break;
                default:
                    newsRecyclerView.setAdapter(topStoriesAdapter);
                    callTopStories(selectedSection);
            }
        }

        return view;
    }

    public void callTopStories(String section) {
        Call<TopStoriesResponse> topStoriesResponseCall;
        switch (section) {
            case "Business":
                topStoriesResponseCall = theNewYorkTimesService.getTopStories("business", BuildConfig.TNYT_API_KEY);
                break;
            case "Arts":
                topStoriesResponseCall = theNewYorkTimesService.getTopStories("arts", BuildConfig.TNYT_API_KEY);
                break;
            case "Politics":
                topStoriesResponseCall = theNewYorkTimesService.getTopStories("politics", BuildConfig.TNYT_API_KEY);
                break;
            case "Sports":
                topStoriesResponseCall = theNewYorkTimesService.getTopStories("sports", BuildConfig.TNYT_API_KEY);
                break;
            case "Travel":
                topStoriesResponseCall = theNewYorkTimesService.getTopStories("travel", BuildConfig.TNYT_API_KEY);
                break;
            case "Technology":
                topStoriesResponseCall = theNewYorkTimesService.getTopStories("technology", BuildConfig.TNYT_API_KEY);
                break;
            default:
                topStoriesResponseCall = theNewYorkTimesService.getTopStories("home", BuildConfig.TNYT_API_KEY);
        }

        topStoriesResponseCall.enqueue(new Callback<TopStoriesResponse>() {
            @Override
            public void onResponse(Call<TopStoriesResponse> call, Response<TopStoriesResponse> response) {
                if (response.body() != null) {
                    topStoriesResultsItems.clear();
                    topStoriesResultsItems.addAll(response.body().getResults());
                    topStoriesAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TopStoriesResponse> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }

    public void callMostPopular() {
        Call<MostPopularResponse> mostPopularResponseCall = theNewYorkTimesService.getMostPopular(1, BuildConfig.TNYT_API_KEY);
        mostPopularResponseCall.enqueue(new Callback<MostPopularResponse>() {
            @Override
            public void onResponse(Call<MostPopularResponse> call, Response<MostPopularResponse> response) {
                Log.d("HAHA", response.body() + "  " + response.raw());
                if (response.body() != null) {
                    mostPopularResultsItems.clear();
                    mostPopularResultsItems.addAll(response.body().getResults());
                    mostPopularAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MostPopularResponse> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }
}
