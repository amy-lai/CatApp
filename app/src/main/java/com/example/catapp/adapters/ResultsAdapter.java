package com.example.catapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catapp.Cat;
import com.example.catapp.R;
//import com.example.catapp.activities.CatDetails;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.CatViewHolder> {
    private List<Cat> catsToAdapt;
  //  private List<Cat> fullListOfCats;

    public void setData(List<Cat> catsToAdapt){
        this.catsToAdapt = catsToAdapt;
    }
//
//    public ResultsAdapter(List<Cat> catsToAdapt){
//        this.catsToAdapt = catsToAdapt;
//       // fullListOfCats = new ArrayList<>();
//    }
    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat, parent, false);

        CatViewHolder catViewHolder = new CatViewHolder(view);

        return catViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        final Cat bookAtPosition = catsToAdapt.get(position);
        holder.bind(bookAtPosition);
    }
    @Override
    public int getItemCount() {
        return catsToAdapt.size();
    }
//
//    @Override
//    public Filter getFilter() {
//        return exampleFilter;
//    }
//    private Filter exampleFilter = new Filter(){
//
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            List<Cat> filteredList = new ArrayList<>();
//            if(constraint == null || constraint.length()==0){
//                filteredList.addAll(fullListOfCats);
//            }
//            else {
//                String filterPattern = constraint.toString().toLowerCase().trim();
//                for(Cat item: fullListOfCats){
//                    if (item.getId().toLowerCase().startsWith(filterPattern)){
//                     filteredList.add(item);
//                    }
//                }
//            }
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//          catsToAdapt.clear();
//          catsToAdapt.addAll((List) results.values);
//          notifyDataSetChanged();
//        }
//    };

    public static class CatViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView breedTextView;
        public TextView descTextView;

        public CatViewHolder (View v){
            super(v);
            view = v;
            breedTextView = v.findViewById(R.id.cat_breed);
            descTextView = v.findViewById(R.id.cat_desc);
        }

        public void bind(final Cat cat) {
            breedTextView.setText(cat.getName());
            descTextView.setText(cat.getDescription());

          /*  view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, CatDetails.class);
                    intent.putExtra("id", cat.getId());
                    context.startActivity(intent);
                }
            });*/

//            shareImageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Context context = view.getContext();
//                    Intent intent = new Intent(Intent.ACTION_SEND);
//
//                    intent.putExtra(Intent.EXTRA_TEXT, book.getTitle());
//                    intent.setType("text/plain");
//                    context.startActivity(intent);
//                }
//            });
//
//            String imageUrl = book.getBookImage();
//            Glide.with(view.getContext()).load(imageUrl).into(coverImageView);
        }

    }
}
