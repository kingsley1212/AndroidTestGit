package com.bai.myapplication.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by  林师金 on 2019/5/5 0005.
 */

public class mySql extends SQLiteOpenHelper {
    public mySql(Context context) {
        super(context, "dasdf.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE jin ( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,name TEXT, age INTEGER, sex TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
