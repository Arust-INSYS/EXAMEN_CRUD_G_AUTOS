package com.crudsqllite.gestionAutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    EditText etCodigo, etDescripcion, etPrecio, etStock;
    Button btnGrabar;
    DAOProducto objDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        etPrecio=(EditText) findViewById(R.id.etPrecio);
        etStock = (EditText) findViewById(R.id.etStock);
        btnGrabar = (Button)  findViewById(R.id.btRegistrar);
        btnGrabar.setOnClickListener(this);
        objDAO = new DAOProducto(this);
    }

    //METODO ONCLICK

    @Override
    public void onClick(View v) {
        Producto objP = new Producto();
        objP.setCodigo(Integer.parseInt(etCodigo.getText().toString()));
        objP.setDescripcion(etDescripcion.getText().toString());
        objP.setPrecio(Double.parseDouble(etPrecio.getText().toString()));
        objP.setStock(Integer.parseInt(etStock.getText().toString()));

        objDAO.nuevoProducto(objP);
        Toast.makeText(this, "Producto registrado OK", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, listado_productos.class);
        startActivity(intent);
    }




}