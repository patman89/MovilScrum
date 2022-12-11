package com.example.movilscrumm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.movilscrumm.Adapters.ProductAdapter;
import com.example.movilscrumm.DB.DBFirebase;
import com.example.movilscrumm.Entities.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> products;
    private DBFirebase dbFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        products = new ArrayList<>();
        /*
        addProduct(R.drawable.regla,"Regla","Regla color amarilla 50 cm","1000");
        addProduct(R.drawable.tijeras,"Tijeras","Iijeras color azul","2000");
        addProduct(R.drawable.lapiz,"Lapiz","Lapiz amarillo No2","1500");
        addProduct(R.drawable.cuaderno,"Cuaderno","Cuaderno pasta dura estilo rayado","3200");
        addProduct(R.drawable.carpeta,"Carpeta","Carpeta de carton tamaño carta","4800");
        addProduct(R.drawable.compas,"Compas","Compas metalico de precisión ","1400");
        addProduct(R.drawable.transportador,"Transportador","Transportador de plastico 180 grados","1300");
        addProduct(R.drawable.cartuchera,"Cartuchera","Estuche pequeño para guardar colores o lapices","7400");
        addProduct(R.drawable.temperas,"Temperas","Temperas pequeñas colores primarios","5300");
        addProduct(R.drawable.pincel,"Pincel","Pincel N° 06 redondo de madera","1400");*/

        productAdapter = new ProductAdapter(this,products);
        listViewProducts.setAdapter(productAdapter);
        dbFirebase = new DBFirebase();
         dbFirebase.getProducts(productAdapter,products);
    }
    /*
        private void addProduct(int image, String name, String description, String price)
        {
            Product product = new Product(image,name,description,price);
            products.add(product);
        }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.addProduct){
            Intent addProductIntent = new Intent(getApplicationContext(), AddProductFormActivity.class);
            startActivity(addProductIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}