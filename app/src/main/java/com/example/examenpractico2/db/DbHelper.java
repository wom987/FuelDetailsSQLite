package com.example.examenpractico2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "parcial.db";
    public static final String TABLE_FACTURAS="t_facturas";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_FACTURAS+ "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "factura INTEGER NOT NULL,"+
                "fecha TEXT NOT NULL,"+
                "tipoComb TEXT NOT NULL,"+
                "montoComp REAL NOT NULL,"+
                "kmt INTEGER NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
