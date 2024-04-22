package com.example.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {
    private static final String EXTRA_MOVIE = "movie";
    private TextView textViewTitle;
    private ImageView imageViewPoster;
    private TextView textViewYear;
    private TextView textViewDescription;

    private void initViews() {
        textViewTitle = findViewById(R.id.textViewTitle);
        imageViewPoster = findViewById(R.id.imageViewPoster);
        textViewYear = findViewById(R.id.textViewYear);
        textViewDescription = findViewById(R.id.textViewDescription);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initViews();
        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        Glide.with(this)
                .load(movie.getPoster().getUrl())
                .into(imageViewPoster);
        textViewTitle.setText(movie.getName());
        textViewYear.setText(movie.getYear());
        textViewDescription.setText(movie.getDescription());
    }

    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }
}