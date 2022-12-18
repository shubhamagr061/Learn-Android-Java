package com.akshara.becomputer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.akshara.becomputer.adapter.DatabaseAdapter;
import com.akshara.becomputer.adapter.FoodEntityAdapter;
import com.akshara.becomputer.adapter.ProductAdapter;
import com.akshara.becomputer.app.App;
import com.akshara.becomputer.database.AppDatabase;
import com.akshara.becomputer.database.dao.FoodDao;
import com.akshara.becomputer.database.model.FoodEntity;
import com.akshara.becomputer.databinding.ActivityDatabaseBinding;
import com.akshara.becomputer.model.Food;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {
    private ActivityDatabaseBinding binding;
    private ArrayList<FoodEntity> foodEntityArrayList = new ArrayList<>();
    private FoodEntityAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setAppBar();

        binding.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatabaseActivity.this, AddRecordActivity.class);
                startActivity(intent);
            }
        });

        binding.rvRecords.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        foodEntityArrayList.addAll(App.foodDao.getAllItems());
        adapter = new FoodEntityAdapter(DatabaseActivity.this, foodEntityArrayList);
        binding.rvRecords.setAdapter(adapter);

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.foodDao.deleteAll();
            }
        });


    }

    private void setAppBar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle(R.string.txtAllFood);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.update((ArrayList<FoodEntity>) App.foodDao.getAllItems());
    }
}