package com.menu.richard.menuapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.menu.richard.menuapp.DBHandler.DatabaseAccess;
import com.menu.richard.menuapp.ExpandableHeightGridView;
import com.menu.richard.menuapp.R;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class WelcomeScreen extends Fragment {

    @SuppressLint("ValidFragment")
    public WelcomeScreen() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.welcome_screen,container,false);

        //returning our layout file
        return view;
       // return inflater.inflate(R.layout.ingredient_list, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Willkommen");
    }
}
