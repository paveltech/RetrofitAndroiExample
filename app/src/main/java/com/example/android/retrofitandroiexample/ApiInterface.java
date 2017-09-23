package com.example.android.retrofitandroiexample;

import com.example.android.retrofitandroiexample.com.pojo.SongsResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by android on 9/20/2017.
 */

public interface ApiInterface {


    //http://api.bollywoodgaana.com/api/v1/actors?api_token=LgGW9icPetuZNcB03nbJ9JioSG02EA5EVQ3gWps9MtGIN1sCTawtKzHFNRvK


    //http://api.bollywoodgaana.com/api/v3/hindi_video?&page=3&api_token=LgGW9icPetuZNcB03nbJ9JioSG02EA5EVQ3gWps9MtGIN1sCTawtKzHFNRvK


    @GET("demo/actors")
    Call<ActorResponce> getActors(@Query("api_token") String apikey);

    @GET("hindi_video?")
    Call<SongsResponce> getSongs(@Query("page") int page, @Query("api_token") String api);

    /*
    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);
    */
}
