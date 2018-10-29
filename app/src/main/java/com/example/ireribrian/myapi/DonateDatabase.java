package com.example.ireribrian.myapi;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ireribrian.myapi.model.User;
import com.example.ireribrian.myapi.view.UserDao;

/**
 * Created by ireribrian on 10/23/2018.
 */

@Database(entities = {User.class}, version  = 1)
public abstract class DonateDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
