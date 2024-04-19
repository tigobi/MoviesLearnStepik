package com.example.movies;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {
    @GET("movie?rating.kp=7-10&sortField=votes.kp&sortType=-1&page=2&limit=5")
    @Headers("X-API-KEY:B30QPKD-NQG4RY1-N4X4C61-Q5J6V7N")
    Single<MovieResponse> loadMovies();
}