package com.example.a13.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class MyOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="register3.db";
    public static final String TABLE_NAME="registeration";
    public static final String COL_1="id";
    public static final String COL_2="age";
    public static final String COL_3="email";
    public static final String COL_4="password";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id TEXT PRIMARY KEY,age TEXT,email TEXT,password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
