package com.example.kinmenfoodmap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StdDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "class";
    private static final int DATABASE_VERSION = 1;
    public StdDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE favorite(" +
                "name text primary key, " +
                "address text not null)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS favorite");
        onCreate(db);
    }
}
