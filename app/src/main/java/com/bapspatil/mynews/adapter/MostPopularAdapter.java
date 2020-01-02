package com.bapspatil.mynews.adapter;
/*
 ** Created by Bapusaheb Patil {@link https://bapspatil.com}
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bapspatil.mynews.R;
import com.bapspatil.mynews.model.most_popular.MostPopularResultsItem;
import com.bapspatil.mynews.util.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.NewsItemViewHolder> {

    private List<MostPopularResultsItem> mostPopularResultsItems = new ArrayList<>();
    private Context context;

    public MostPopularAdapter(List<MostPopularResultsItem> mostPopularResultsItems) {
        this.mostPopularResultsItems = mostPopularResultsItems;
    }

    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder holder, int position) {
        MostPopularResultsItem mostPopularResultsItem = mostPopularResultsItems.get(position);

        holder.dateTextView.setText(mostPopularResultsItem.getPublishedDate().substring(0, 10) + ""); // 20/01/2019
        holder.sectionTextView.setText(mostPopularResultsItem.getSection() + "");
        holder.titleTextView.setText(mostPopularResultsItem.getTitle() + "");
        if (mostPopularResultsItem.getMedia().size() > 0 && mostPopularResultsItem.getMedia().get(0).getMediaMetadata().size() > 0)
            GlideApp.with(context)
                    .load(mostPopularResultsItem.getMedia().get(0).getMediaMetadata().get(0).getUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(holder.newsImageView);
    }

    @Override
    public int getItemCount() {
        if (mostPopularResultsItems == null) return 0;
        else return mostPopularResultsItems.size();
    }

    public class NewsItemViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImageView;
        TextView sectionTextView;
        TextView dateTextView;
        TextView titleTextView;

        public NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.iv_news);
            sectionTextView = itemView.findViewById(R.id.tv_section);
            dateTextView = itemView.findViewById(R.id.tv_date);
            titleTextView = itemView.findViewById(R.id.tv_title);
        }
    }
}
