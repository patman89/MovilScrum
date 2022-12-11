package com.example.movilscrumm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationProductActivity extends AppCompatActivity {
    private Button btnBack;
    private ImageView imageProduct;

    private TextView textProductName;
    private TextView textProductDescription;
    private TextView textProductPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_product);

        btnBack = (Button) findViewById(R.id.btnBack);
        imageProduct = (ImageView) findViewById(R.id.imageProduct);
        textProductName = (TextView) findViewById(R.id.productName);
        textProductDescription = (TextView) findViewById(R.id.productDescription);
        textProductPrice = (TextView) findViewById(R.id.productPrice);
        getInformation();
        setBackButton();
    }
    private void getInformation(){
        Intent intentInListInformation =getIntent();
        imageProduct.setImageResource(intentInListInformation.getIntExtra("image",0));
        textProductName.setText(intentInListInformation.getStringExtra("name"));
        textProductDescription.setText(intentInListInformation.getStringExtra("description"));
        textProductPrice.setText(intentInListInformation.getStringExtra("price"));
    }
    private void setBackButton() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listProductIntent = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(listProductIntent);
            }
        });
    }
}