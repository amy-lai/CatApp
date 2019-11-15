package com.example.catapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catapp.Cat;
import com.example.catapp.R;
import com.example.catapp.adapters.FavsAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavouritesRecycler extends Fragment {

    private RecyclerView recyclerView;

    public FavouritesRecycler() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.favourites_list, container, false);
        recyclerView = view.findViewById(R.id.favs_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        final FavsAdapter adapter = new FavsAdapter();

        Cat cat = new Cat("beng","Bengal", "Orange");
        Cat cat2 = new Cat("beng","Bengal", "Orange");
        List<Cat> sample = new ArrayList<>();
        sample.add(cat);
        sample.add(cat2);
        adapter.setData(sample);

        recyclerView.setAdapter(adapter);

        return view;
    }
}

