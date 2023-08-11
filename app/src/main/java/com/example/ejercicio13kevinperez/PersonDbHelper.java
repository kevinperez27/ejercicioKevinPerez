package com.example.ejercicio13kevinperez;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "person.db";
    private static final int DATABASE_VERSION = 1;

    public PersonDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PERSON_TABLE = "CREATE TABLE " +
                PersonContract.PersonEntry.TABLE_NAME + " (" +
                PersonContract.PersonEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PersonContract.PersonEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                PersonContract.PersonEntry.COLUMN_LAST_NAME + " TEXT NOT NULL, " +
                PersonContract.PersonEntry.COLUMN_AGE + " INTEGER NOT NULL, " +
                PersonContract.PersonEntry.COLUMN_EMAIL + " TEXT, " +
                PersonContract.PersonEntry.COLUMN_ADDRESS + " TEXT);";

        db.execSQL(SQL_CREATE_PERSON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PersonContract.PersonEntry.TABLE_NAME);
        onCreate(db);
    }
}
