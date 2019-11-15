/*
package com.example.catapp.activities;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.catapp.Cat;
import com.example.catapp.R;
import com.example.catapp.adapters.ResultsAdapter;
import com.example.catapp.fragments.ResultsRecycler;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchableActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    public void doMySearch(String query) {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://api.thecatapi.com/v1/images/search?breed_ids="+query;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // This method, onResponse, is executed after a response is received for your request.
                // Logically, this means it is the only place where you are guarantee that a response
                // has been received.
                // So, you must write all the code that depends on having a response here.
                // For example, converting the response to objects using Gson.

                Gson gson = new Gson();
                Cat cat = gson.fromJson(response, Cat.class);
                List<Cat> catList = Arrays.asList(cat);

                Intent intent = new Intent(getApplicationContext(), ResultsAdapter.class);

                getApplicationContext().startActivity(intent);


                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);

        // This line simply adds the request to the queue. It's not necessarily going to be executed
        // immediately (there could possibly be other requests in the queue).
        // Also, because requests to the internet take time, we cannot guarantee that the response
        // will be received right away.
        // We are NOT GUARANTEED to have a response after this line.
        // That is the purpose of the onResponse method in the response listener.
        requestQueue.add(stringRequest);
    }
//    public void populate (){
//        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//        String url = "https://api.thecatapi.com/v1/breeds";
//        Response.Listener<String> responseListener = new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Gson gson = new Gson();
//                Cat cat = gson.fromJson(response, Cat.class);
//                List<Cat> catList = Arrays.asList(cat);
//                ResultsAdapter r = new ResultsAdapter(catList);
//                ResultsRecycler.recyclerView.setAdapter(r);
//            }
//        };
//    }
}
*/
