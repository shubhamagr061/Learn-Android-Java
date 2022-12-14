package com.akshara.becomputer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.akshara.becomputer.app.App;
import com.akshara.becomputer.database.dao.FoodDao;
import com.akshara.becomputer.database.model.FoodEntity;
import com.akshara.becomputer.databinding.ActivityAddRecordBinding;

public class AddRecordActivity extends AppCompatActivity {

    private FoodDao dao;
    private ActivityAddRecordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddRecordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setAppBar();

        binding.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {

                    FoodEntity food = new FoodEntity();
                    food.setFood_id(Integer.parseInt(binding.etFoodId.getText().toString()));
                    food.setName(binding.etName.getText().toString());
                    food.setPrice(Double.parseDouble(binding.etPrice.getText().toString()));

                    App.foodDao.insertItem(food);

                    Toast.makeText(AddRecordActivity.this, "Record Added", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private boolean validateForm() {
        if (binding.etPrice.getText().toString().isEmpty()) {
            binding.etPrice.setError("Empty value not accepted");
            return false;
        }
        if (binding.etName.getText().toString().isEmpty()) {
            binding.etName.setError("Empty value not accepted");
            return false;
        }
        if (binding.etFoodId.getText().toString().isEmpty()) {
            binding.etFoodId.setError("Empty value not accepted");
            return false;
        }
        return true;
    }

    private void setAppBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.txtAddRecord);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}