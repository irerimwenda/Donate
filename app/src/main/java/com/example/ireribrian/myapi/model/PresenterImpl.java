package com.example.ireribrian.myapi.model;

import android.text.TextUtils;

import com.example.ireribrian.myapi.presenter.LoginPresenter;
import com.example.ireribrian.myapi.view.LoginView;

/**
 * Created by ireribrian on 10/21/2018.
 */

public class PresenterImpl implements LoginPresenter{

    LoginView mLoginView;

    public PresenterImpl(LoginView loginView){

        this.mLoginView = loginView;

    }

    @Override
    public void performLogin(String userName, String password) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
            mLoginView.loginValidations();
        }

        else{
            if(userName.equals("brian")  && password.equals("ireri")){
                mLoginView.loginSuccess();
            }

            else {
                mLoginView.loginError();
            }
        }

    }
}
