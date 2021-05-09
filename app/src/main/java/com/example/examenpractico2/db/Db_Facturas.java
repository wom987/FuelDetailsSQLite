package com.example.examenpractico2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db_Facturas extends DbHelper {
    Context context;
    public Db_Facturas(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertFactura(int factura, String fecha, String tipoCom, double montoC, int KM){
        long id=0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put( "factura", factura);
            contentValues.put("fecha",fecha);
            contentValues.put("tipoComb",tipoCom);
            contentValues.put("montoComp",montoC);
            contentValues.put("kmt",KM);

            id =sqLiteDatabase.insert(TABLE_FACTURAS,null,contentValues);

        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
