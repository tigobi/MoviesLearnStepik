package com.example.movies;

import com.google.gson.annotations.SerializedName;


public class Review {
    @SerializedName("author")
    private String author;
    @SerializedName("review")
    private String Review;
    @SerializedName("type")
    private String type;

    public Review(String author, String review, String type) {
        this.author = author;
        Review = review;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getReview() {
        return Review;
    }

    public String getType() {
        return type;
    }
}
