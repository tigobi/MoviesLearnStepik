package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder> {
    private static final String TYPE_POSITIVE = "Позитивный";
    private static final String TYPE_NEUTRAL = "Нейтральный";
    private List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);
        holder.textViewAuthor.setText(review.getAuthor());
        holder.textViewReview.setText(review.getReview());
        int colorResId = android.R.color.holo_red_light;
        if (review.getType() != null) {
            String type = review.getType();
            switch (type) {
                case TYPE_POSITIVE:
                    colorResId = android.R.color.holo_green_light;
                    break;
                case TYPE_NEUTRAL:
                    colorResId = android.R.color.holo_orange_light;
                    break;
            }
        } else {
            colorResId = android.R.color.holo_orange_light;
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(), colorResId);
        holder.linearLayoutReviews.setBackgroundColor(color);

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout linearLayoutReviews;
        private final TextView textViewAuthor;
        private final TextView textViewReview;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutReviews = itemView.findViewById(R.id.linearLayoutReviews);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);
        }
    }
}
