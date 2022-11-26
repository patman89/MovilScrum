package com.example.movilscrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnInformacionPrimerProducto;
    private Button btnInformacionSegundoProducto;
    private Button btnInformacionTercerProducto;
    private TextView textNombrePrimerProducto;
    private TextView textNombreSegundoProducto;
    private TextView textNombreTercerProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInformacionPrimerProducto = (Button) findViewById(R.id.btnPrimerProducto);
        btnInformacionSegundoProducto = (Button) findViewById(R.id.btnSegundoProducto);
        btnInformacionTercerProducto = (Button) findViewById(R.id.btnTercerProducto);

        textNombrePrimerProducto = (TextView) findViewById(R.id.nombrePrimerProducto);
        textNombreSegundoProducto = (TextView) findViewById(R.id.nombreSegundoProducto);
        textNombreTercerProducto = (TextView) findViewById(R.id.nombreTercerProducto);
    }

    private void configurarBotones(){
        btnInformacionPrimerProducto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mostrarInformacion(textNombrePrimerProducto.getText().toString(),"Primer Producto");
            }
        });btnInformacionPrimerProducto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mostrarInformacion(textNombreSegundoProducto.getText().toString(),"Segundo Producto");
            }
        });btnInformacionPrimerProducto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mostrarInformacion(textNombreTercerProducto.getText().toString(),"Tercer Producto";
            }
        });
    }

    private void mostrarInformacion(String nombreProducto, String descripcionProducto){
        Intent intent = new Intent(getApplicationContext(),activity_informacionProducto2.class);
        startActivity(intent);
    }
}