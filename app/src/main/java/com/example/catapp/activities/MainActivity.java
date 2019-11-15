package com.example.catapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.catapp.R;
import com.example.catapp.fragments.FavouritesRecycler;
import com.example.catapp.fragments.ResultsRecycler;
import com.example.catapp.fragments.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new FavouritesRecycler();
        swapFragment(fragment);

        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // menuItem = the item on the bottom nav view that was selected
                // The id's here belong to the items in the navi_menu of the BottomnNavigationView
                // The navi_menu is chunked out as bottom_nav_menu.xml in the res > navi_menu folder
                if (menuItem.getItemId() == R.id.nav_search) {
                    Fragment fragment = new ResultsRecycler();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_favs) {
                    Fragment fragment = new FavouritesRecycler();

//                    // Here's just an example of passing information to the Fragment via Bundle
//                    Bundle bundle = new Bundle();
//                    bundle.puutString("param2", "Second Argument");
////                    fragment.setArguments(bundle);
////                    // End bundle parttString("param1", "First Argument");
//                    bundle.p

                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }
    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
