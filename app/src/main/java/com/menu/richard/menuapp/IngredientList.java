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
import android.widget.TextView;
import android.widget.Toast;

import com.menu.richard.menuapp.DBHandler.DatabaseAccess;
import com.menu.richard.menuapp.DBHandler.DatabaseOpenHelper;
import com.menu.richard.menuapp.Entities.FoodType;
import com.menu.richard.menuapp.Entities.Ingredient;
import com.menu.richard.menuapp.Entities.Unit;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class IngredientList extends Fragment {
    private DatabaseAccess d;

    @SuppressLint("ValidFragment")
    public IngredientList(DatabaseAccess d) {
        this.d = d;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ingredient_list,container,false);

        ExpandableHeightGridView gridViewFruits = (ExpandableHeightGridView) view.findViewById(R.id.gridViewIngredientFruit);
        ExpandableHeightGridView gridViewVegetables = (ExpandableHeightGridView) view.findViewById(R.id.gridViewIngredientVegetable);
        ExpandableHeightGridView gridViewProteins = (ExpandableHeightGridView) view.findViewById(R.id.gridViewIngredientProtein);
        ExpandableHeightGridView gridViewPantries = (ExpandableHeightGridView) view.findViewById(R.id.gridViewIngredientPantry);
        ExpandableHeightGridView gridViewSpices = (ExpandableHeightGridView) view.findViewById(R.id.gridViewIngredientSpice);

        gridViewFruits.setExpanded(true);
        gridViewVegetables.setExpanded(true);
        gridViewProteins.setExpanded(true);
        gridViewPantries.setExpanded(true);
        gridViewSpices.setExpanded(true);

        List<Ingredient> ingredients = d.getIngredients();

        List<Ingredient> fruits = getAllIngredientsFromFoodType(ingredients, FoodType.FRUIT);
        List<Ingredient> vegetables = getAllIngredientsFromFoodType(ingredients, FoodType.VEGETABLE);
        List<Ingredient> proteins = getAllIngredientsFromFoodType(ingredients, FoodType.PROTEIN);
        List<Ingredient> pantries = getAllIngredientsFromFoodType(ingredients, FoodType.PANTRY);
        List<Ingredient> spices = getAllIngredientsFromFoodType(ingredients, FoodType.SPICE);

        ArrayAdapter<Ingredient> adapterFruits = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, fruits);
        ArrayAdapter<Ingredient> adapterVegetables = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, vegetables);
        ArrayAdapter<Ingredient> adapterProteins = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, proteins);
        ArrayAdapter<Ingredient> adapterPantries = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, pantries);
        ArrayAdapter<Ingredient> adapterSpices = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, spices);

        gridViewFruits.setAdapter(adapterFruits);
        gridViewVegetables.setAdapter(adapterVegetables);
        gridViewProteins.setAdapter(adapterProteins);
        gridViewPantries.setAdapter(adapterPantries);
        gridViewSpices.setAdapter(adapterSpices);

        //returning our layout file
        return view;
       // return inflater.inflate(R.layout.ingredient_list, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Zutatenliste");
    }

    private List<Ingredient> getAllIngredientsFromFoodType(List<Ingredient> ingredients, FoodType foodType) {
        List<Ingredient> ret = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getFoodType().equals(foodType)) {
                ret.add(ingredient);
            }
        }
        return ret;
    }
}
