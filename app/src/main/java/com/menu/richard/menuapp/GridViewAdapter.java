package com.menu.richard.menuapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.menu.richard.menuapp.Entities.Meal;
import com.menu.richard.menuapp.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.DataObjectHolder> {
        private static String LOG_TAG = "MyRecyclerViewAdapter";
        private ArrayList<Meal> mDataset;
        private static MyClickListener myClickListener;

        public static class DataObjectHolder extends RecyclerView.ViewHolder
                implements View
                .OnClickListener {
            TextView mealName;
            ImageView mealImage;

            public DataObjectHolder(View itemView) {
                super(itemView);
                mealName = (TextView) itemView.findViewById(R.id.meal_name);
                mealImage = (ImageView) itemView.findViewById(R.id.meal_image);
                Log.i(LOG_TAG, "Adding Listener");
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                myClickListener.onItemClick(getAdapterPosition(), v);
            }
        }

        public void setOnItemClickListener(MyClickListener myClickListener) {
            this.myClickListener = myClickListener;
        }

    public GridViewAdapter(ArrayList<Meal> myDataset) {
            mDataset = myDataset;
        }

        @Override
        public DataObjectHolder onCreateViewHolder(ViewGroup parent,
        int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recipe_index, parent, false);

            DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
            return dataObjectHolder;
        }

        @Override
        public void onBindViewHolder(DataObjectHolder holder, int position) {
            holder.mealName.setText(mDataset.get(position).getName());
            holder.mealImage.setImageBitmap(mDataset.get(position).getImage());
        }

        public void addItem(Meal dataObj, int index) {
            mDataset.add(index, dataObj);
            notifyItemInserted(index);
        }

        public void deleteItem(int index) {
            mDataset.remove(index);
            notifyItemRemoved(index);
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public interface MyClickListener {
            public void onItemClick(int position, View v);
        }
}