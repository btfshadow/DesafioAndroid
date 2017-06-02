package br.com.concretesolutions.repository.api;

import br.com.concretesolutions.repository.api.types.RegionType;
import br.com.concretesolutions.repository.model.Movie;
import br.com.concretesolutions.repository.model.Page;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {

    @GET("movie/now_playing")
    Call<Page<Movie>> getNowPlaying(@Query("region") @RegionType String region, @Query("page") int page);

}
