package com.menu.richard.menuapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

public class DetailedMeal extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detailed_meal,container,false);
        Button bIngredient = (Button) view.findViewById(R.id.buttonIngredient);
        Button bInstruction = (Button) view.findViewById(R.id.buttonInstruction);
        view.findViewById(R.id.buttonIngredient).setOnClickListener(mListener);
        view.findViewById(R.id.buttonInstruction).setOnClickListener(mListener);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Detailed Meal");
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
