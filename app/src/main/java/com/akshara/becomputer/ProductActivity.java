package com.akshara.becomputer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.akshara.becomputer.model.Product;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView rvProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        rvProduct = findViewById(R.id.rvProduct);
        initData();

    }

    private void initData() {
        Product product = new Product();
        product.setId(1);
        product.setName("Mac Book 13 Inch");
        product.setCategory("Laptop");
        product.setPrice(1500.00);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Mac Book 14 Inch");
        product2.setCategory("Laptop");
        product2.setPrice(2200.00);

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Mac Book 16 Inch");
        product3.setCategory("Laptop");
        product3.setPrice(2500.00);

        Product product4 = new Product();
        product4.setId(4);
        product4.setName("Dell XPS 13 Inch");
        product4.setCategory("Laptop");
        product4.setPrice(2200.00);

        Product product5 = new Product();
        product5.setId(5);
        product5.setName("Dell XPS 15 Inch");
        product5.setCategory("Laptop");
        product5.setPrice(2600.00);


    }
}