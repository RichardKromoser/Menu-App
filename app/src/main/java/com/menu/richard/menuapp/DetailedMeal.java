package com.menu.richard.menuapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.menu.richard.menuapp.DBHandler.DatabaseAccess;
import com.menu.richard.menuapp.Entities.Ingredient;
import com.menu.richard.menuapp.Entities.Meal;
import com.menu.richard.menuapp.Entities.Unit;

import java.util.List;
import java.util.Map;

@SuppressLint("ValidFragment")
public class DetailedMeal extends Fragment {
    DatabaseAccess d;
    String title;
    Meal m;

    @SuppressLint("ValidFragment")
    public DetailedMeal(DatabaseAccess d, Meal meal) {
        this.d = d;
        this.m = meal;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detailed_meal,container,false);
        Button bIngredient = (Button) view.findViewById(R.id.buttonIngredient);
        Button bInstruction = (Button) view.findViewById(R.id.buttonInstruction);
        view.findViewById(R.id.buttonIngredient).setOnClickListener(mListener);
        view.findViewById(R.id.buttonInstruction).setOnClickListener(mListener);

        title=m.getName();

        TextView totaltime = (TextView)view.findViewById(R.id.textTime);
        totaltime.setText(m.getTotalTime());

        ImageView mealImage = (ImageView) view.findViewById(R.id.detailImage);
        mealImage.setImageBitmap(m.getImage());

        List<String> ingredient = m.getIngredients();
        ExpandableHeightGridView ingredients = view.findViewById(R.id.listviewIngredients);

        ingredients.setExpanded(true);

        ArrayAdapter<String> adapterIngredient = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, ingredient);
        ingredients.setAdapter(adapterIngredient);

        List<String> instruction = m.getInstructions();
        ExpandableHeightGridView instructions = view.findViewById(R.id.listviewInstruction);

        instructions.setExpanded(true);

        ArrayAdapter<String> adapterInstruction = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, instruction);
        instructions.setAdapter(adapterInstruction);


        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(title);
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttonIngredient:
                    System.out.println("Ingredient");
                    break;
                case R.id.buttonInstruction:
                    System.out.println("Instruction");
                    break;
            }
        }
    };
}
