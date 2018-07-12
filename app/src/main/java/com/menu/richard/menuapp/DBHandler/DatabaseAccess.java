package com.menu.richard.menuapp.DBHandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
     * @return a List of Units
     */
    public List<String> getUnits() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("select * from Unit", null);

        if (cursor.moveToFirst()) {
            System.out.print("HIER");
            //Loop through the table rows
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        /*while (!cursor.isAfterLast()) {
            list.add(cursor.getString(cursor.getColumnIndex("name")));
            cursor.moveToNext();
        }*/
        cursor.close();
        return list;
    }
}
