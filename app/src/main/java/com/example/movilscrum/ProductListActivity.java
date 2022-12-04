package com.example.movilscrum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.movilscrum.Adapaters.ProductAdapter;
import com.example.movilscrum.Entities.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_product);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        products = new ArrayList<>();
        AddProduct(R.drawable.regla,"Regla","Regla color amarilla 50 cm","1000");
        AddProduct(R.drawable.tijeras,"Tijeras","Iijeras color azul","1000");
        AddProduct(R.drawable.lapiz,"Lapiz","Lapiz amarillo No2","1500");
        AddProduct(R.drawable.cuaderno,"Cuaderno","Cuaderno descripcion","1200");
        AddProduct(R.drawable.carpeta,"Carpeta","Carpeta descripcion","1800");
        AddProduct(R.drawable.compas,"Compas","Compas descripcion","1400");
        AddProduct(R.drawable.transportador,"Transportador","Transportador descripcion","1300");
        AddProduct(R.drawable.cartuchera,"Cartuchera","Cartuchera descripcion","1400");
        AddProduct(R.drawable.temperas,"Temperas","Temperas descripcion","1300");
        AddProduct(R.drawable.pincel,"Pincel","Pincel descripcion","1400");

        productAdapter = new ProductAdapter(this,products);
        listViewProducts.setAdapter(productAdapter);
    }

    private void AddProduct(int image, String name, String description, String price)
    {
        Product product = new Product(image,name,description,price);
        products.add(product);
    }
}