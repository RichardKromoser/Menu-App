package com.menu.richard.menuapp.DBHandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import com.menu.richard.menuapp.Entities.Category;
import com.menu.richard.menuapp.Entities.FoodType;
import com.menu.richard.menuapp.Entities.Ingredient;
import com.menu.richard.menuapp.Entities.Meal;
import com.menu.richard.menuapp.Entities.Unit;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all units from the database.
     *
     * @return a List of UnitsUnit.valueOf(cursor.getString(cursor.getColumnIndex("name")))
     */
    public List<Unit> getUnits() {
        List<Unit> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from Unit", null);
        while (cursor.moveToNext()) {
            list.add(Unit.valueOf(cursor.getString(cursor.getColumnIndex("name"))));
        }

        cursor.close();
        return list;
    }

    /**
     * Read all categories from the database.
     *
     * @return a List of Categories
     */
    public List<String> getCategories() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Category", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    /**
     * Read all types of food from the database.
     *
     * @return a List of FoodTypes
     */
    public List<String> getFoodTypes() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM FoodType", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    /**
     * Read all ingredients from the database.
     *
     * @return a List of Ingredients
     */
    public List<Ingredient> getIngredients() {
        List<Ingredient> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from Ingredient order by name", null);
        while (cursor.moveToNext()) {
            Ingredient i = new Ingredient(cursor.getString(cursor.getColumnIndex("name")), FoodType.values()[cursor.getInt(cursor.getColumnIndex("foodtype"))]);
            list.add(i);
        }
        cursor.close();
        return list;
    }

    /**
     * Read all meals from the database.
     *
     * @return a List of Meals
     */
    public List<Meal> getMeals() {
        List<Meal> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM Meal order by name", null);
        while (cursor.moveToNext()) {
            byte[] image;
            image = cursor.getBlob(cursor.getColumnIndex("image"));
            Bitmap decodedImage = BitmapFactory.decodeByteArray(image, 0, image.length);
            Category category = Category.values()[cursor.getInt(cursor.getColumnIndex("category"))];
            Meal m = new Meal(decodedImage, category, cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("time")),cursor.getString(cursor.getColumnIndex("ingredients")),cursor.getString(cursor.getColumnIndex("instructions")));
            list.add(m);
        }
        cursor.close();
        return list;
    }
}
