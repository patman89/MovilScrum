package com.example.movilscrumm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.movilscrumm.DB.DBFirebase;
import com.example.movilscrumm.Entities.Product;

public class AddProductFormActivity extends AppCompatActivity {
    private Button btnSaveNewProduct;
    private ImageView imageProductToAdd;
    private EditText nameProductToAdd;
    private EditText descriptionProductToAdd;
    private EditText priceProductToAdd;
    private DBFirebase dbFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_form);
        btnSaveNewProduct = (Button) findViewById(R.id.btnSaveNewProduct);
        imageProductToAdd = (ImageView) findViewById(R.id.imageProductToAdd);
        nameProductToAdd = (EditText) findViewById(R.id.nameProductToAdd);
        descriptionProductToAdd = (EditText) findViewById(R.id.descriptionProductToAdd);
        priceProductToAdd = (EditText) findViewById(R.id.priceProductToAdd);
        dbFirebase = new DBFirebase();
        setSaveButton();
    }

    private void setSaveButton() {
        btnSaveNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product(
                        nameProductToAdd.getText().toString(),
                        descriptionProductToAdd.getText().toString(),
                        priceProductToAdd.getText().toString()
                );
                dbFirebase.insertProduct(product);
                Toast.makeText(getApplicationContext(), "Save Product", Toast.LENGTH_SHORT).show();
                Intent productListIntent = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(productListIntent);
            }
        });

    }
}