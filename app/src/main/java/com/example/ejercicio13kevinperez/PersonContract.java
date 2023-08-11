package com.example.ejercicio13kevinperez;

import android.provider.BaseColumns;

public final class PersonContract {
    private PersonContract() {}

    public static class PersonEntry implements BaseColumns {
        public static final String TABLE_NAME = "person";
        public static final String COLUMN_NAME = "nombre";
        public static final String COLUMN_LAST_NAME = "apellidos";
        public static final String COLUMN_AGE = "edad";
        public static final String COLUMN_EMAIL = "correo";
        public static final String COLUMN_ADDRESS = "direccion";
    }
}

