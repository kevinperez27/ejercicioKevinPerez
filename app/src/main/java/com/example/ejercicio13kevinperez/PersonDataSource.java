package com.example.ejercicio13kevinperez;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PersonDataSource {
    private SQLiteDatabase database;
    private final PersonDbHelper dbHelper;

    public PersonDataSource(Context context) {
        dbHelper = new PersonDbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertPerson(Person person) {
        ContentValues values = new ContentValues();
        values.put(PersonContract.PersonEntry.COLUMN_NAME, person.getNombre());
        values.put(PersonContract.PersonEntry.COLUMN_LAST_NAME, person.getApellidos());
        values.put(PersonContract.PersonEntry.COLUMN_AGE, person.getEdad());
        values.put(PersonContract.PersonEntry.COLUMN_EMAIL, person.getCorreo());
        values.put(PersonContract.PersonEntry.COLUMN_ADDRESS, person.getDireccion());

        return database.insert(PersonContract.PersonEntry.TABLE_NAME, null, values);
    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        Cursor cursor = database.query(
                PersonContract.PersonEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMN_NAME));
            @SuppressLint("Range") String apellidos = cursor.getString(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMN_LAST_NAME));
            @SuppressLint("Range") int edad = cursor.getInt(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMN_AGE));
            @SuppressLint("Range") String correo = cursor.getString(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMN_EMAIL));
            @SuppressLint("Range") String direccion = cursor.getString(cursor.getColumnIndex(PersonContract.PersonEntry.COLUMN_ADDRESS));

            persons.add(new Person(nombre, apellidos, edad, correo, direccion));
            cursor.moveToNext();
        }
        cursor.close();

        return persons;
    }
}

