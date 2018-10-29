package com.example.ireribrian.myapi.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ireribrian.myapi.DonateDatabase;
import com.example.ireribrian.myapi.R;
import com.example.ireribrian.myapi.model.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddContactActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    Button adduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        phoneNumber = findViewById(R.id.phone_number);
        adduser = findViewById(R.id.add_user_btn);

        final DonateDatabase db = Room.databaseBuilder(getApplicationContext(), DonateDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 10/23/2018 Save to DB

                String firstname = firstName.getText().toString();
                String lastname = lastName.getText().toString();
                String phonenumber = phoneNumber.getText().toString();

                if(TextUtils.isEmpty(firstname)){
                    Toast.makeText(AddContactActivity.this, "Please enter firstname", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(lastname)){
                    Toast.makeText(AddContactActivity.this, "Please enter lastname", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(phonenumber)){
                    Toast.makeText(AddContactActivity.this, "Please enter phone number", Toast.LENGTH_SHORT).show();
                }

                User user = new User(firstName.getText().toString(),
                        lastName.getText().toString(),
                        phoneNumber.getText().toString());

                db.userDao().insertAll(user);

                startActivity(new Intent(AddContactActivity.this, Home.class));
            }
        });
    }
}
