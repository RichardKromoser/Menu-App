package com.menu.richard.menuapp;

import android.provider.ContactsContract;
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

        GridView simpleList;
        List<Meal> birdList;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            DatabaseAccess d = DatabaseAccess.getInstance(this);
            d.open();
            birdList = d.getMeals();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            simpleList = (GridView) findViewById(R.id.grid_view_recipe_index);

            GridViewAdapter myAdapter=new GridViewAdapter(this,R.layout.recipe_meal,(ArrayList)birdList);
            simpleList.setAdapter(myAdapter);

        }
}
