package com.example.android.retrofitandroiexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    public static final String TAG = MainActivity.class.getSimpleName();
    public final static String api_key = "LgGW9icPetuZNcB03nbJ9JioSG02EA5EVQ3gWps9MtGIN1sCTawtKzHFNRvK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (api_key.isEmpty()){
            Toast.makeText(this, "Api is empty", Toast.LENGTH_SHORT).show();
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
