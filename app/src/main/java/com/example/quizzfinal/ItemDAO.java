package com.example.quizzfinal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    public void insert(Result... items);
    @Update
    public void update(Result... items);
    @Delete
    public void delete(Result items);

    @Query("SELECT * FROM items")
    public List<Result> getItems();
}
