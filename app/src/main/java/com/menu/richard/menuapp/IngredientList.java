package com.menu.richard.menuapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.menu.richard.menuapp.DBHandler.DatabaseAccess;
import com.menu.richard.menuapp.DBHandler.DatabaseOpenHelper;
import com.menu.richard.menuapp.Entities.Ingredient;
import com.menu.richard.menuapp.Entities.Unit;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class IngredientList extends Fragment {
    private DatabaseAccess d;

    @SuppressLint("ValidFragment")
    public IngredientList(DatabaseAccess databaseAccess) {
        this.d =databaseAccess;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ingredient_list,container,false);
        GridView gridView = (GridView) view.findViewById(R.id.gridviewIngredient);
        List<Ingredient> ingredients = d.getIngredients();

        ArrayAdapter<Ingredient> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, ingredients);
        gridView.setAdapter(adapter);
        //returning our layout file
        return inflater.inflate(R.layout.ingredient_list, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Zutatenliste");
    }
}
