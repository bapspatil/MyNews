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
import com.bapspatil.mynews.model.top_stories.TopStoriesResultsItem;
import com.bapspatil.mynews.util.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.NewsItemViewHolder> {

    private List<TopStoriesResultsItem> topStoriesResultsItems = new ArrayList<>();
    private Context context;

    public TopStoriesAdapter(List<TopStoriesResultsItem> topStoriesResultsItems) {
        this.topStoriesResultsItems = topStoriesResultsItems;
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
        TopStoriesResultsItem topStoriesResultsItem = topStoriesResultsItems.get(position);

        holder.dateTextView.setText(topStoriesResultsItem.getPublishedDate().substring(0, 10) + ""); // 20/01/2019
        if (topStoriesResultsItem.getSubsection() != null && !topStoriesResultsItem.getSubsection().isEmpty())
            holder.sectionTextView.setText(topStoriesResultsItem.getSection() + " > " + topStoriesResultsItem.getSubsection());
        else
            holder.sectionTextView.setText(topStoriesResultsItem.getSection() + "");
        holder.titleTextView.setText(topStoriesResultsItem.getTitle() + "");
        if (topStoriesResultsItem.getMultimedia().size() > 0)
            GlideApp.with(context)
                    .load(topStoriesResultsItem.getMultimedia().get(0).getUrl())
                    .fallback(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.newsImageView);
    }

    @Override
    public int getItemCount() {
        if (topStoriesResultsItems == null) return 0;
        else return topStoriesResultsItems.size();
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
