package com.example.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.country.Adapter.RvAdapter;
import com.example.country.Modle.Country;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity
{
 private static final String URL_DATA="https://restcountries.eu/rest/v2/region/Asia";
 private RecyclerView recyclerView;
 private RvAdapter rvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.CountryRvId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        loadRecyclerViewData();

    }
    private void loadRecyclerViewData()
    {

        StringRequest request =new StringRequest(URL_DATA, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {

                Log.d("code",response);
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson= gsonBuilder.create();
              Country[] countries=  gson.fromJson(response, Country[].class);
                rvAdapter=new RvAdapter(getApplicationContext(),countries,MainActivity.this);
                recyclerView.setAdapter(rvAdapter);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}