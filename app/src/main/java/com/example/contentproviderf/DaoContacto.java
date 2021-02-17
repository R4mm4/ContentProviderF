package com.example.contentproviderf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DaoContacto {
    Context context;
    BD admin;
    SQLiteDatabase BaseDeDatos;
    public DaoContacto(Context ctx){
        this.context=ctx;
        admin= new BD(ctx,"Datos",null,1);
        BaseDeDatos= admin.getWritableDatabase();
    }
    public void Registrar(Contacto contacto){

        ContentValues registro = new ContentValues();
        registro.put("nombre",contacto.getNomnbre());
        registro.put("apellido",contacto.getApellido());
        registro.put("telefono",contacto.getTelefono());
        BaseDeDatos.insert("contactos",null,registro);
        BaseDeDatos.close();
    }
    public Cursor ConsultarTodas(){
        return  BaseDeDatos.rawQuery("select * from contactos",null);
    }
    public void EliminarUno(String  ID){
        int cantidad = BaseDeDatos.delete("contactos","ID="+"=?",new String[]{ID});
        BaseDeDatos.close();
    }
    public void Modificar(Contacto contacto){
        ContentValues registro = new ContentValues();
        registro.put("Nombre",contacto.getNomnbre());
        registro.put("apellido",contacto.getApellido());
        registro.put("telefono",contacto.getTelefono());
        int cantidad = BaseDeDatos.update("contactos",registro,"ID="+"=?",new String[]{""+contacto.getId()});
        BaseDeDatos.close();

    }

}
