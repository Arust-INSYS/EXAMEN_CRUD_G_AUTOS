package com.crudsqllite.gestionAutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.crudsqllite.gestionAutos.modelo.Auto;
import com.crudsqllite.gestionAutos.modelo.DAOAuto;

import java.util.ArrayList;

public class listado_autos extends AppCompatActivity implements View.OnClickListener{

    ListView lvAutos;
    Button btnRetornar;

    DAOAuto objDAO;
    ArrayList<Auto> aAutos;
    ArrayAdapter<Auto> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_autos);

        lvAutos = (ListView) findViewById(R.id.lvProductos);
        btnRetornar= (Button) findViewById(R.id.btRetornar);
        btnRetornar.setOnClickListener(this);
        listaAutos();
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(listado_autos.this, MainActivity.class);
        startActivity(intent);
    }
    private void listaAutos() {
        objDAO = new DAOAuto(this);
        aAutos = objDAO.listadoAutos();
        objDAO.close();

        adaptador = new ArrayAdapter<Auto>(this,
                android.R.layout.simple_list_item_1, aAutos);
        lvAutos.setAdapter(adaptador);
    }
}