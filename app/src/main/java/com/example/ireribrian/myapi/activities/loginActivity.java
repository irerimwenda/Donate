package com.example.ireribrian.myapi.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ireribrian.myapi.R;
import com.example.ireribrian.myapi.model.PresenterImpl;
import com.example.ireribrian.myapi.presenter.LoginPresenter;
import com.example.ireribrian.myapi.view.LoginView;

public class loginActivity extends Activity implements View.OnClickListener, LoginView{

    EditText etUserName, etPassword;
    TextView tvLogin;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        tvLogin = findViewById(R.id.tvLogin);

        tvLogin.setOnClickListener(this);

        mLoginPresenter = new PresenterImpl(loginActivity.this);
    }

    @Override
    public void onClick(View view) {

        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        mLoginPresenter.performLogin(userName,password);

    }

    @Override
    public void loginValidations() {

        Toast.makeText(getApplicationContext(), "Please Enter Username & Password", Toast.LENGTH_LONG).show();

    }

    @Override
    public void loginSuccess() {

        final Intent homeIntent = new Intent(loginActivity.this,Home.class);
        startActivity(homeIntent);

    }

    @Override
    public void loginError() {

        Toast.makeText(getApplicationContext(), "Login Failure", Toast.LENGTH_SHORT).show();

    }
}
