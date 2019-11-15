package com.example.catapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.widget.SearchView;
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
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Result;

public class ResultsRecycler extends Fragment {
    private RecyclerView recyclerView;

    private List<Cat> catList = new ArrayList<>();

    public ResultsRecycler() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_results, container, false);
        recyclerView = view.findViewById(R.id.cats_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        final ResultsAdapter adapter = new ResultsAdapter();

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String url = "https://api.thecatapi.com/v1/breeds";
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Cat cat = gson.fromJson(response, Cat.class);
                catList = Arrays.asList(cat);
                requestQueue.stop();
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);
        requestQueue.add(stringRequest);

        adapter.setData(catList);
        recyclerView.setAdapter(adapter);
        return view;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//      //  MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.navi_menu,menu);
//        MenuItem searchItem = menu.findItem(R.id.nav_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter(newText);
//                return false;
//            }
//        });
//    }
}
