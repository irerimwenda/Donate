package com.example.ireribrian.myapi.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ireribrian.myapi.DonateDatabase;
import com.example.ireribrian.myapi.R;
import com.example.ireribrian.myapi.model.User;
import com.example.ireribrian.myapi.presenter.UserAdapter;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

public class Home extends AppCompatActivity {

    //LinearLayout bottomsheetlayout;
    BottomSheetBehavior bottomSheetBehavior;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    MaterialSearchView searchView;

    String arrayName [] = {"Whatsapp",
    "Facebook", "Twitter", "Google +", "Linkedin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Contacts");

       // MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);

        DonateDatabase db = Room.databaseBuilder(getApplicationContext(), DonateDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        List<User> users = db.userDao().getAllUsers();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);

        View bottomSheet = findViewById(R.id.bottomsheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        // bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);



/**
        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.bv, R.drawable.cs)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.whatsapp)
                .addSubMenu(Color.parseColor("#6d4c41"), R.drawable.facebook)
                .addSubMenu(Color.parseColor("#ff0000"), R.drawable.twitter)
                .addSubMenu(Color.parseColor("#03a9f4"), R.drawable.googleplus)
                .addSubMenu(Color.parseColor("#1a237e"), R.drawable.linkedin)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        Toast.makeText(Home.this, "You selected " + arrayName[index], Toast.LENGTH_SHORT).show();

                    }
                });**/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        ///MenuItem item = menu.findItem(R.id.action_search);
        //searchView.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (item.getItemId() == R.id.add){
            final Intent adduserIntent = new Intent(Home.this, AddContactActivity.class);
            startActivity(adduserIntent);
        }else
            if(item.getItemId() == R.id.share){
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            }

            return super.onOptionsItemSelected(item);
    }
}
