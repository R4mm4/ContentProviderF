package com.example.contentproviderf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnGuardar,btnMostrar;
    EditText txtNombre,txtApe,txtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGuardar =(Button) findViewById(R.id.btnGuardar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);

        txtNombre =(EditText)findViewById(R.id.txtNombre);
        txtApe=(EditText)findViewById(R.id.txtApellido);
        txtTelefono=(EditText)findViewById(R.id.txtTelefono);
    }
    public void guardar(View v){
        BD bd = new BD(this,"Datos",null,1);
        SQLiteDatabase sql = bd.getWritableDatabase();
        try{
            ContentValues in = new ContentValues();
            in.put("nombre",txtNombre.getText().toString());
            in.put("apellido",txtApe.getText().toString());
            in.put("telefono",txtTelefono.getText().toString());
            sql.insert("Contactos",null,in);
            sql.close();
            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(this,"Ocurrio un error",Toast.LENGTH_SHORT).show();

        }
    }
    public void registros(View v){
        startActivity(new Intent(MainActivity.this,Lista.class));
    }
}