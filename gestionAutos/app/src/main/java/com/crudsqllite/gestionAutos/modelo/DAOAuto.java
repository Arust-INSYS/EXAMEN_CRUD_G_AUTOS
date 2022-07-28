package com.crudsqllite.gestionAutos.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DAOAuto extends SQLiteOpenHelper {

    private static final String base="AUTOS.db";
    private static final int version=1;
    private static final String tabla="AUTO";

    //DEFINICION DE LAS COLUMNAS
    private static final String cod_auto = "COD_AUTO";
    private static final String marc_auto = "MARC_AUTO";
    private static final String model_auto ="MODEL_AUTO";
    private static final String fecha_auto="FECHA_AUTO";
    private static final String chas_auto="CHAS_AUTO";
    private static final String transm_auto="TRANS_AUTO";
    private static final String access_auto="ACCES_AUTO";
    private static final String val_auto="VAL_AUTO";
    private static final String sto_auto="STO_AUTO";

    public DAOAuto(Context  context){

        super(context, base, null, version);
    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL="CREATE TABLE "+tabla+" ("+cod_auto+" text PRIMARY KEY,"
                +marc_auto+" text,"+model_auto+" text,"
                +fecha_auto+" text," +chas_auto+" text,"
                +transm_auto+" text," +access_auto+ " text,"
                +val_auto+" text,"+sto_auto+" text)";
        db.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+tabla);
        onCreate(db);

    }

    //Metodo para registrar un producto
    public void nuevoAuto(Auto objP){
        ContentValues values =new ContentValues();
        values.put(cod_auto,objP.getCodigo());
        values.put(marc_auto,objP.getMarca());
        values.put(model_auto,objP.getModelo());
        values.put(fecha_auto,objP.getAnyo());
        values.put(chas_auto,objP.getChasis());
        values.put(transm_auto,objP.getTransmision());
        values.put(access_auto,objP.getAccesorios());
        values.put(val_auto,objP.getValor());
        values.put(sto_auto,objP.getStock());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(tabla, null, values);
        db.close();
    }
    //Metodo para listar Autos
    public ArrayList listadoAutos(){
        ArrayList listaAutos = new ArrayList();
        SQLiteDatabase db = getWritableDatabase();
        String SQL="SELECT * FROM " +tabla;
        Cursor c=db.rawQuery(SQL,null);
        if(c.moveToFirst()){
            do {
                listaAutos.add(c.getString(0) + " " + c.getString(1) + " "
                        + c.getString(2) + " " + c.getString(3)
                        + " " + c.getString(4)+ " " + c.getString(5)
                        + " " + c.getString(6)+ " " + c.getString(7)
                        + " " + c.getString(8));
            }while(c.moveToNext());
        }
        return listaAutos;

    }


}
