package com.example.movilscrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductListActivity extends AppCompatActivity {

    private Button btnInformationFirstProduct;
    private Button btnInformationSecondProduct;
    private Button btnInformationThirdProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_product);

        btnInformationFirstProduct = (Button) findViewById(R.id.btnFirstProduct);
        btnInformationSecondProduct = (Button) findViewById(R.id.btnSecondProduct);
        btnInformationThirdProduct = (Button) findViewById(R.id.btnThirdProduct);

        setButtons();
    }

    private void setButtons(){
        btnInformationFirstProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
               sentInformation( R.drawable.regla, R.string.first_product_name, R.string.first_product_description);
            }
        });
        btnInformationSecondProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                sentInformation(R.drawable.tijeras, R.string.second_product_name, R.string.second_product_description);
            }
        });
        btnInformationThirdProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                sentInformation(R.drawable.lapiz, R.string.third_product_name, R.string.third_product_description);
            }
        });
    }

    private void sentInformation(int imageProduct, int productName, int productDescription){
        Intent infoProductIntent = new Intent(getApplicationContext(), InformationProductActivity.class);
        infoProductIntent.putExtra("image",imageProduct);
        infoProductIntent.putExtra("name",productName);
        infoProductIntent.putExtra("description",productDescription);
        startActivity(infoProductIntent);
    }
}