package com.menu.richard.menuapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.menu.richard.menuapp.DBHandler.DatabaseAccess;
import com.menu.richard.menuapp.Entities.Meal;

import java.sql.DatabaseMetaData;
import java.util.List;

public class RecipeAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    List<Meal> meals;
    Context context;
    DatabaseAccess d;

    public RecipeAdapter(List<Meal> meals, Context context,DatabaseAccess d) {
        this.meals = meals;
        this.context = context;
        this.d =d;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.recipe_meal, null);
        holder.mealName = (TextView) rowView.findViewById(R.id.meal_name);
        holder.mealImage = (ImageView) rowView.findViewById(R.id.meal_image);

        holder.mealName.setText(meals.get(position).getName());
        holder.mealImage.setImageBitmap(meals.get(position).getImage());

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Class fragmentClass = DetailedMeal.class;
                Fragment fragment = null;
                try {
                    fragment = (Fragment) fragmentClass.getDeclaredConstructor(DatabaseAccess.class, Meal.class).newInstance(d, meals.get(position));
                } catch (Exception e) {
                    e.printStackTrace();
                }

               FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });



        return rowView;
    }

    public class Holder {
        TextView mealName;
        ImageView mealImage;
    }

}