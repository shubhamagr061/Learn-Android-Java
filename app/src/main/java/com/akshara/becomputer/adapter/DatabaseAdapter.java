package com.akshara.becomputer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshara.becomputer.R;
import com.akshara.becomputer.api.Api;
import com.akshara.becomputer.database.model.FoodEntity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.DatabaseViewHolder> {
    private Context context;
    private ArrayList<FoodEntity> foodEntityArrayList;

    public DatabaseAdapter(Context context, ArrayList<FoodEntity> foodEntityArrayList) {
        this.context = context;
        this.foodEntityArrayList = foodEntityArrayList;
    }

    @NonNull
    @Override
    public DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_food, parent, false);
        return new DatabaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseViewHolder holder, int position) {
        FoodEntity item = foodEntityArrayList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(String.valueOf(item.getPrice()));
        Glide.with(context)
                .load(Api.BASE_URL + item.getUrl())
                .placeholder(R.drawable.dish)
                .into(holder.ivFood);
    }

    @Override
    public int getItemCount() {
        return foodEntityArrayList.size();
    }

    public class DatabaseViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFood;
        private TextView tvName, tvPrice;

        public DatabaseViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFood = itemView.findViewById(R.id.ivFood);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }

    public void update(ArrayList<FoodEntity> newArrayList){
        foodEntityArrayList.clear();
        foodEntityArrayList.addAll(newArrayList);
        notifyDataSetChanged();
    }
}
