package com.example.movilscrumm.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movilscrumm.Entities.Product;
import com.example.movilscrumm.InformationProductActivity;
import com.example.movilscrumm.R;

import java.util.ArrayList;

public class ProductAdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int index, View covertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        covertView = layoutInflater.inflate(R.layout.product_list_template,null);

        Product product = products.get(index);

        ImageView imageProduct = (ImageView) covertView.findViewById(R.id.imageListProduct);
        TextView nameProduct = (TextView) covertView.findViewById(R.id.nameListProduct);
        Button btnInformationProduct = (Button) covertView.findViewById(R.id.btnInfoProduct);


        imageProduct.setImageResource(product.getImage());
        nameProduct.setText(product.getName());

        setInformationButton(product, btnInformationProduct);

        return covertView;
    }

    private void setInformationButton(Product product, Button btnInformationProduct) {
        btnInformationProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view) {
                Intent infoProductIntent = new Intent(context.getApplicationContext(), InformationProductActivity.class);
                infoProductIntent.putExtra("image", product.getImage());
                infoProductIntent.putExtra("name", product.getName());
                infoProductIntent.putExtra("description", product.getDescription());
                infoProductIntent.putExtra("price", product.getPrice());
                context.startActivity(infoProductIntent);
            }
        });
    }
}
