package com.example.movilscrum;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


public class activity_informacionProducto2 extends AppCompatActivity {
    private Button btnVolver;
    private TextView textNombreProducto;
    private TextView textDescripcionProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnVolver = (Button) findViewById(R.id.btnVolver);
        textNombreProducto = (TextView) findViewById(R.id.nombreProducto);
        textDescripcionProducto = (TextView) findViewById(R.id.descripcionProducto);
    }
    public void configurarInformacionProducto(String nombreProducto, String descripcionProducto){
        textNombreProducto.setText(nombreProducto);
        textDescripcionProducto.setText(descripcionProducto);

    }
}