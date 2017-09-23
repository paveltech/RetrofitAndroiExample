package com.example.android.retrofitandroiexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.android.retrofitandroiexample.com.pojo.SongsItem;
import com.example.android.retrofitandroiexample.com.pojo.SongsResponce;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    public static final String TAG = MainActivity.class.getSimpleName();
    public final static String api_key = "LgGW9icPetuZNcB03nbJ9JioSG02EA5EVQ3gWps9MtGIN1sCTawtKzHFNRvK";

    public RecyclerView recyclerView;
    public MoviesAdapter adapter;

    private int pageToDownload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (api_key.isEmpty()){
            Toast.makeText(this, "Api is empty", Toast.LENGTH_SHORT).show();
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);



        /*
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ActorResponce> call = apiInterface.getActors(api_key);
        call.enqueue(new Callback<ActorResponce>() {
            @Override
            public void onResponse(Call<ActorResponce> call, Response<ActorResponce> response) {
                ArrayList<Actorlist> actorlistArrayList = response.body().getActorlistArrayList();
                recyclerView.setAdapter(new MoviesAdapter(actorlistArrayList , R.layout.list_item_movie , getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ActorResponce> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Not responding", Toast.LENGTH_SHORT).show();
            }
        });
        */

        pageToDownload = 1;
        adapter = new MoviesAdapter(R.layout.list_item_movie , getApplicationContext());
        apiCall(pageToDownload);
        Log.d("call-1" , "Api call");

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // Load more if RecyclerView has reached the end and isn't already loading
                if (linearLayoutManager.findLastVisibleItemPosition() == adapter.movies.size()-1) {

                    if (pageToDownload < 999) {
                        Toast.makeText(MainActivity.this, "New page loading", Toast.LENGTH_SHORT).show();
                        apiCall(pageToDownload);
                        Log.d("call-2" , "Api call");
                    }
                }
            }
        });
    }

    public void apiCall(int pageNumber){
        Log.d("new page" , ""+pageNumber);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final Call<SongsResponce> songsResponceCall = apiInterface.getSongs( pageNumber, api_key);
        //Log.d("url" , ""+songsResponceCall.request().url().toString());

        songsResponceCall.enqueue(new Callback<SongsResponce>() {
            @Override
            public void onResponse(Call<SongsResponce> call, Response<SongsResponce> response) {

                ArrayList<SongsItem> songsItemArrayList = response.body().getSongsItemArrayList();
                adapter.addSongs(songsItemArrayList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<SongsResponce> call, Throwable t) {

            }

        });
    }

    public void dataInput(){

        pageToDownload++;
    }
}
