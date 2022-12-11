package com.example.movilscrumm.DB;

import androidx.annotation.NonNull;

import com.example.movilscrumm.Adapters.ProductAdapter;
import com.example.movilscrumm.Entities.Product;
import com.example.movilscrumm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebase {
    private FirebaseFirestore db;

    public DBFirebase (){ this.db = FirebaseFirestore.getInstance();}

    public  void insertProduct(Product product){
        //Crear nuevo producto
        Map<String,Object> productMap = new HashMap<>();
        productMap.put("id", product.getId());
        productMap.put("name", product.getName());
        productMap.put("description", product.getDescription());
        productMap.put("price", product.getPrice());
        // Añadir el nuevo producto con un id
        db.collection("products").add(product);
    }
    public  void getProducts(ProductAdapter productAdapter, ArrayList<Product> products){
        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(!task.isSuccessful())
                            return;
                        for(QueryDocumentSnapshot document: task.getResult()) {
                            Product product = new Product(
                                    R.drawable.maleta,
                                    document.getData().get("name").toString(),
                                    document.getData().get("description").toString(),
                                    document.getData().get("price").toString()
                            );
                            products.add(product);
                        }
                        productAdapter.notifyDataSetChanged();
                    }
                });

    }
}
