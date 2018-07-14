package com.menu.richard.menuapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.menu.richard.menuapp.DBHandler.DatabaseAccess;
import com.menu.richard.menuapp.Entities.Meal;

import java.util.ArrayList;
import java.util.List;

public class RecipeIndex extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecipeIndexActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        ArrayList<Meal> meals = (ArrayList)databaseAccess.getMeals();

        mRecyclerView = (RecyclerView) findViewById(R.id.content_frame);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new GridViewAdapter(meals);
        mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
   /*     ((GridViewAdapter) mAdapter).setOnItemClickListener(new GridViewAdapter()
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        }); */
    }
}
