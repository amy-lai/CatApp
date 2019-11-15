package com.example.catapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catapp.Cat;
import com.example.catapp.R;
import com.example.catapp.fragments.FavouritesRecycler;

import java.util.ArrayList;
import java.util.List;

public class FavsAdapter extends RecyclerView.Adapter<FavsAdapter.CatViewHolder>{
    private List<Cat> cats = new ArrayList<>();

    public void setData(List<Cat> catsToAdapt){
        this.cats = catsToAdapt;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view =
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.cat, parent, false);

            FavsAdapter.CatViewHolder catVH = new FavsAdapter.CatViewHolder(view);
            return catVH;
    }

    @Override
    public void onBindViewHolder(@NonNull FavsAdapter.CatViewHolder holder, int position) {
        final Cat bookAtPosition = cats.get(position);
        holder.bind(bookAtPosition);
    }
    @Override
    public int getItemCount() {
        return cats.size();
    }
    public static class CatViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView breedTextView;
        public TextView descTextView;

        public CatViewHolder(View v) {
            super(v);
            view = v;
            breedTextView = v.findViewById(R.id.cat_breed);
            descTextView = v.findViewById(R.id.cat_desc);
        }

        public void bind(final Cat cat) {
            breedTextView.setText(cat.getName());
            descTextView.setText(cat.getDescription());
        }
    }
}
