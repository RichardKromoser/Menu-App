package com.menu.richard.menuapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.menu.richard.menuapp.DBHandler.DatabaseAccess;
import com.menu.richard.menuapp.Entities.Meal;

import java.util.List;

@SuppressLint("ValidFragment")
public class RecipeIndex extends Fragment {

        DatabaseAccess d;

    public RecipeIndex(DatabaseAccess d) {
        this.d = d;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recipe_index,container,false);

        GridView gridView = (GridView) view.findViewById(R.id.grid_view_recipe_index);

        List<Meal> meals = d.getMeals();

        gridView.setAdapter(new RecipeAdapter(meals, getContext(),d));

        //returning our layout file
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Rezept Index");
    }

}
