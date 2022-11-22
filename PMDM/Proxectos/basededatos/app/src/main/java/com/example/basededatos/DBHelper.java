package com.example.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String CREATE_DATABASE_COMMENTS = "CREATE TABLE comments(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, phone_number TEXT)";
    private static final String DB_NAME = "test.prueba"; // DB name
    private static final int DB_SCHEME_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE_COMMENTS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion , int newVersion) {

    }
}
