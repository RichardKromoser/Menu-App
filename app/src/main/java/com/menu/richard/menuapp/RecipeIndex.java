package com.menu.richard.menuapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class RecipeIndex extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recipe_index,container,false);
        GridView gridView = (GridView) view.findViewById(R.id.gridviewRecipe);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String a = String.valueOf(position);
                System.out.println(parent.getItemAtPosition(position));
                Toast.makeText(getContext().getApplicationContext(), a, Toast.LENGTH_SHORT).show();
            }
        });
        gridView.setAdapter(new GridViewAdapter(view.getContext())); // uses the view to get the context instead of getActivity().
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Rezept Index");
    }
}
