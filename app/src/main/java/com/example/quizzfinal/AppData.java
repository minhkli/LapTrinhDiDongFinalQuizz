package com.example.quizzfinal;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// tạo database dữ liệu lưu sqlite
@Database(entities = {Result.class}, version = 1)
public abstract class AppData extends RoomDatabase {
    public abstract ItemDAO getItemDAO();
}