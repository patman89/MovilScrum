package com.example.movilscrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddProductFormActivity extends AppCompatActivity {
    private Button btnSaveNewProduct;
    private ImageView imageProductToAdd;
    private EditText nameProductToAdd;
    private EditText descriptionProductToAdd;
    private EditText priceProductToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_form);
        btnSaveNewProduct = (Button) findViewById(R.id.btnSaveNewProduct);
        imageProductToAdd = (ImageView) findViewById(R.id.imageProductToAdd);
        nameProductToAdd = (EditText) findViewById(R.id.nameProductToAdd);
        descriptionProductToAdd = (EditText) findViewById(R.id.descriptionProductToAdd);
        priceProductToAdd = (EditText) findViewById(R.id.priceProductToAdd);
        SetSaveButton();
    }

    private void SetSaveButton(){
        btnSaveNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Save Product",Toast.LENGTH_SHORT).show();
                Intent productListIntent = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(productListIntent);
            }
        });

    }
}