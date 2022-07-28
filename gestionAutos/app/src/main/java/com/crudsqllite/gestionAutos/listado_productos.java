package com.crudsqllite.gestionAutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class listado_productos extends AppCompatActivity implements View.OnClickListener{

    ListView lvProductos;
    Button btnRetornar;

    DAOProducto objDAO;
    ArrayList<Producto> aProductos;
    ArrayAdapter<Producto> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_productos);

        lvProductos = (ListView) findViewById(R.id.lvProductos);
        btnRetornar= (Button) findViewById(R.id.btRetornar);
        btnRetornar.setOnClickListener(this);
        listaProductos();
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(listado_productos.this, MainActivity.class);
        startActivity(intent);
    }
    private void listaProductos() {
        objDAO = new DAOProducto(this);
        aProductos = objDAO.listadoProductos();
        objDAO.close();

        adaptador = new ArrayAdapter<Producto>(this,
                android.R.layout.simple_list_item_1, aProductos);
        lvProductos.setAdapter(adaptador);
    }
}