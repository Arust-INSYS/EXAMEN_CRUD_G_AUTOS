package com.crudsqllite.gestionAutos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DAOProducto extends SQLiteOpenHelper {

    private static final String base="Ventas.db";
    private static final int version=1;
    private static final String tabla="PRODUCTO";

    //DEFINICION DE LAS COLUMNAS
    private static final String cod_pro = "COD_PRO";
    private static final String des_pro = "DES_PRO";
    private static final String pre_pro="PRE_PRO";
    private static final String sto_pro="STO_PRO";

    public DAOProducto(Context  context){

        super(context, base, null, version);
    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL="CREATE TABLE "+tabla+" ("+cod_pro+" text PRIMARY KEY,"
                +des_pro+" text,"+pre_pro+" text,"
                +sto_pro+" text)";
        db.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+tabla);
        onCreate(db);

    }

    //Metodo para registrar un producto
    public void nuevoProducto(Producto objP){
        ContentValues values =new ContentValues();
        values.put(cod_pro,objP.getCodigo());
        values.put(des_pro,objP.getDescripcion());
        values.put(pre_pro,objP.getPrecio());
        values.put(sto_pro,objP.getStock());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(tabla, null, values);
        db.close();
    }
    //Metodo para listar Productos
    public ArrayList listadoProductos(){
        ArrayList listaProductos = new ArrayList();
        SQLiteDatabase db = getWritableDatabase();
        String SQL="SELECT * FROM " +tabla;
        Cursor c=db.rawQuery(SQL,null);
        if(c.moveToFirst()){
            do {
                listaProductos.add(c.getString(0) + " " + c.getString(1) + " "
                        + c.getString(2) + " " + c.getString(3));
            }while(c.moveToNext());
        }
        return listaProductos;

    }


}
