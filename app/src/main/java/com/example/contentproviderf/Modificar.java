package com.example.contentproviderf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modificar extends AppCompatActivity {
    EditText txtNombre,txtApellido,txtTelefono;
    Button btnModificar,btnEliminar;
    int id;
    String Nombre,Telefono,Apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtApellido = (EditText)findViewById(R.id.txtApellido);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        btnModificar=(Button)findViewById(R.id.btnGuardarCambios);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            id=bundle.getInt("Id");
            Nombre=bundle.getString("Nombre");
            Apellido=bundle.getString("Apellido");
            Telefono=bundle.getString("Telefono");
        }
        txtNombre.setText(Nombre);
        txtApellido.setText(Apellido);

    }
    public void Eliminar (View v){
        DaoContacto daoContacto = new DaoContacto(getApplicationContext());
        daoContacto.EliminarUno(id+"");
    }
    public void Modificar(View v){
        DaoContacto daoContacto = new DaoContacto(getApplicationContext());
        Contacto contacto = new Contacto(id,txtNombre.getText().toString(),txtApellido.getText().toString(),txtTelefono.getText().toString());
        daoContacto.Modificar(contacto);
    }
}