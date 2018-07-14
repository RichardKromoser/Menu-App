package com.menu.richard.menuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.menu.richard.menuapp.Entities.Meal;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter {

    ArrayList<Meal> birdList = new ArrayList<>();

    public GridViewAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        birdList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.recipe_meal, null);
        TextView textView = (TextView) v.findViewById(R.id.meal_name);
        ImageView imageView = (ImageView) v.findViewById(R.id.meal_img);
        textView.setText(birdList.get(position).getName());
        imageView.setImageBitmap(birdList.get(position).getImage());
        return v;

    }

}