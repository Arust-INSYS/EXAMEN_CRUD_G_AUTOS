package com.crudsqllite.gestionAutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crudsqllite.gestionAutos.modelo.Auto;
import com.crudsqllite.gestionAutos.modelo.DAOAuto;

import java.sql.Date;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    EditText etCodigo, etMarca, etModelo, etFecha, etChasis, etTransmision,
            etAccesorios, etValor, etStock;
    Button btnGrabar;
    DAOAuto objDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etMarca = (EditText) findViewById(R.id.etMarca);
        etModelo=(EditText) findViewById(R.id.etModelo);
        etFecha=(EditText) findViewById(R.id.etFecha);
        etChasis=(EditText) findViewById(R.id.etChasis);
        etTransmision=(EditText) findViewById(R.id.etTransmision);
        etAccesorios=(EditText) findViewById(R.id.etAccesorios);
        etValor=(EditText) findViewById(R.id.etValor);
        etStock = (EditText) findViewById(R.id.etStock);


        btnGrabar = (Button)  findViewById(R.id.btRegistrar);
        btnGrabar.setOnClickListener(this);
        objDAO = new DAOAuto(this);
    }

    //METODO ONCLICK

    @Override
    public void onClick(View v) {
        Auto objP = new Auto();
        objP.setCodigo(Integer.parseInt(etCodigo.getText().toString()));
        objP.setMarca(etMarca.getText().toString());
        objP.setModelo(etModelo.getText().toString());
        objP.setAnyo(etFecha.getText().toString());
        objP.setChasis( etChasis.getText().toString());
        objP.setTransmision(etTransmision.getText().toString());
        objP.setAccesorios(etAccesorios.getText().toString());
        objP.setValor(Double.parseDouble(etValor.getText().toString()));
        objP.setStock(Integer.parseInt(etStock.getText().toString()));

        objDAO.nuevoAuto(objP);
        Toast.makeText(this, "Auto registrado OK", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, listado_autos.class);
        startActivity(intent);
    }




}