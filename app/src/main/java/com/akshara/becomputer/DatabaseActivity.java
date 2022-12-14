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
import com.akshara.becomputer.app.App;
import com.akshara.becomputer.database.AppDatabase;
import com.akshara.becomputer.database.dao.FoodDao;
import com.akshara.becomputer.database.model.FoodEntity;
import com.akshara.becomputer.databinding.ActivityDatabaseBinding;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {
//
//    private RecyclerView rvRecords;
//    private AppDatabase db;
//    private FoodDao foodDao;
//
    private ActivityDatabaseBinding binding;
//    private DatabaseAdapter adapter;
//    private ArrayList<FoodEntity> foodEntityArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatabaseActivity.this, AddRecordActivity.class);
                startActivity(intent);
            }
        });

        binding.rvRecords.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));

    }
}