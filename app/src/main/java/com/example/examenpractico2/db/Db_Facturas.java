package com.example.examenpractico2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.examenpractico2.Entities.Facturas;

import java.util.ArrayList;

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
    public ArrayList<Facturas> mostrarContactos() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Facturas> listaFacturas = new ArrayList<>();
        Facturas factura;
        Cursor cursoFacturas;

        cursoFacturas = db.rawQuery("SELECT * FROM " + TABLE_FACTURAS, null);

        if (cursoFacturas.moveToFirst()) {
            do {
                factura = new Facturas();
                factura.setId(cursoFacturas.getInt(0));
                factura.setFactura(cursoFacturas.getInt(1));
                factura.setFecha(cursoFacturas.getString(2));
                factura.setTipoComb(cursoFacturas.getString(3));
                factura.setMontoComp(cursoFacturas.getDouble(4));
                factura.setKmt(cursoFacturas.getInt(1));

                listaFacturas.add(factura);
            } while (cursoFacturas.moveToNext());
        }

        cursoFacturas.close();

        return listaFacturas;
    }
}
