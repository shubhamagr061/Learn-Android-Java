package com.akshara.becomputer.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.akshara.becomputer.database.dao.FoodDao;
import com.akshara.becomputer.database.model.FoodEntity;

@Database(entities = {FoodEntity.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "becomputer";
    private static AppDatabase instance;

    public abstract FoodDao foodDao();
    public static AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room
                    .databaseBuilder(context.getApplicationContext(),AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
