package com.example.android.retrofitandroiexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android on 9/20/2017.
 */

public class ApiClient {


    //http://api.bollywoodgaana.com/api/v1/actors?api_token=LgGW9icPetuZNcB03nbJ9JioSG02EA5EVQ3gWps9MtGIN1sCTawtKzHFNRvK

    public static final String BASE_URL = "http://api.bollywoodgaana.com/api/";
    public static Retrofit retrofit = null;


    public static Retrofit getClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
