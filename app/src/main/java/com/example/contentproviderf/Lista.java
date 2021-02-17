package com.example.contentproviderf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    ListView listView;
    ArrayList<Contacto>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listView = (ListView) findViewById(R.id.lstV);
        cargar();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int ID=list.get(position).getId();
                String nombre=list.get(position).getNomnbre();
                String apellido=list.get(position).getApellido();
                String telefono=list.get(position).getTelefono();
                Intent intent = new Intent(Lista.this,Modificar.class);
                intent.putExtra("Id",ID);
                intent.putExtra("Nombre",nombre);
                intent.putExtra("Apellido",apellido);
                intent.putExtra("Telefono",telefono);
                startActivity(intent);
            }
        });

        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }
    public void consultar(){
        DaoContacto daoContacto = new DaoContacto(getApplicationContext());
        Contacto contacto = null;
        list = new ArrayList<>();
        Cursor cursor = daoContacto.ConsultarTodas();
        while(cursor.moveToNext()){
            contacto = new Contacto(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
            list.add(contacto);
        }
    }
    public void cargar(){
        consultar();
        ArrayAdapter<Contacto> adapter = new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
