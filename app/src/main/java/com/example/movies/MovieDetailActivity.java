package com.example.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {
    private static final String TAG = "MovieDetailActivity";
    private static final String EXTRA_MOVIE = "movie";
    private MovieDetailViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(MovieDetailViewModel.class);
        initViews();
        Movie movie = (Movie) getIntent().getSerializableExtra(EXTRA_MOVIE);

        Glide.with(this)
                .load(movie.getPoster().getUrl())
                .into(imageViewPoster);
        textViewTitle.setText(movie.getName());
        textViewYear.setText(movie.getYear());
        textViewDescription.setText(movie.getDescription());
        viewModel.loadTrailers(movie.getId());
        viewModel.getTrailers().observe(this, new Observer<List<Trailer>>() {
            @Override
            public void onChanged(List<Trailer> trailers) {
                Log.d(TAG, "GET TRAILERS ");
            }
        });
    }

    public static Intent newIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }
}