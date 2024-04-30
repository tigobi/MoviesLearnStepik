package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v1.4/movie?token=B30QPKD-NQG4RY1-N4X4C61-Q5J6V7N&field=rating.kp&search=7-10&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("v1.4/movie/{idFilms}?token=B30QPKD-NQG4RY1-N4X4C61-Q5J6V7N")
    Single<TrailerResponse> loadTrailers(@Path("idFilms") int idFilms);

    @GET("v1.4/review?token=B30QPKD-NQG4RY1-N4X4C61-Q5J6V7N")
    Single<ReviewResponse> loadReviews(@Query("movieId") int idFilms);
}