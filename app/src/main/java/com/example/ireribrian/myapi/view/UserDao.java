package com.example.ireribrian.myapi.view;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ireribrian.myapi.model.User;

import java.util.List;

/**
 * Created by ireribrian on 10/23/2018.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User>getAllUsers();

    @Insert
    void insertAll(User... users);
}