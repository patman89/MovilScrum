package com.example.movilscrum;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class InformationProductActivity extends AppCompatActivity {
    private Button btnBack;
    private ImageView imageProduct;

    private TextView textProductName;
    private TextView textProductDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        btnBack = (Button) findViewById(R.id.btnBack);
        textProductName = (TextView) findViewById(R.id.productName);
        textProductDescription = (TextView) findViewById(R.id.productDescription);
        imageProduct = (ImageView) findViewById(R.id.imageProduct);
       getInformation();
       setBackButton();
    }
    private void getInformation(){
        Intent intentInListInformation =getIntent();
        imageProduct.setImageResource(intentInListInformation.getIntExtra("image",0));
        textProductName.setText(intentInListInformation.getIntExtra("name",0));
        textProductDescription.setText(intentInListInformation.getIntExtra("description",0));
    }
    private void setBackButton(){
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent listProductIntent = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(listProductIntent);
            }
        });
    }
}