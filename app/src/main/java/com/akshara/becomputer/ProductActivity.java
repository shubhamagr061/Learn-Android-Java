package com.akshara.becomputer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.akshara.becomputer.adapter.ProductAdapter;
import com.akshara.becomputer.api.ApiClient;
import com.akshara.becomputer.api.ApiInterface;
import com.akshara.becomputer.model.Product;
import com.akshara.becomputer.response.FoodResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
//        Product product = new Product();
//        product.setId(1);
//        product.setName("Mac Book 13 Inch");
//        product.setCategory("Laptop");
//        product.setPrice(1500.00);
//
//        Product product2 = new Product();
//        product2.setId(2);
//        product2.setName("Mac Book 14 Inch");
//        product2.setCategory("Laptop");
//        product2.setPrice(2200.00);
//
//        Product product3 = new Product();
//        product3.setId(3);
//        product3.setName("Mac Book 16 Inch");
//        product3.setCategory("Laptop");
//        product3.setPrice(2500.00);
//
//        Product product4 = new Product();
//        product4.setId(4);
//        product4.setName("Dell XPS 13 Inch");
//        product4.setCategory("Laptop");
//        product4.setPrice(2200.00);
//
//        Product product5 = new Product();
//        product5.setId(5);
//        product5.setName("Dell XPS 15 Inch");
//        product5.setCategory("Laptop");
//        product5.setPrice(2600.00);

//        ArrayList<Product> productArrayList = new ArrayList<>();
//        productArrayList.add(product);
//        productArrayList.add(product2);
//        productArrayList.add(product3);
//        productArrayList.add(product4);
//        productArrayList.add(product5);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<FoodResponse> call = apiInterface.getFood();
        call.enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                FoodResponse rs = response.body();
                if(rs.isSuccess()){
                    ProductAdapter adapter = new ProductAdapter(ProductActivity.this,
                            rs.getData());
                    rvProduct.setLayoutManager(new LinearLayoutManager(ProductActivity.this,
                            LinearLayoutManager.VERTICAL,false));
                    rvProduct.setAdapter(adapter);
                }else{
                   Toast.makeText(ProductActivity.this, rs.getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                Toast.makeText(ProductActivity.this, t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });






    }
}