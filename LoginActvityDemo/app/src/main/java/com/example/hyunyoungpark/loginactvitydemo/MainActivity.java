package com.example.hyunyoungpark.loginactvitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    TextView status;
    LoginButton login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        status = (TextView)findViewById(R.id.txt_status);
        login = (LoginButton)findViewById(R.id.btn_login);
        login.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        status.setText("LOGIN SUCCESSFULL\n"+
                                loginResult.getAccessToken().getUserId());
                    }
                    @Override
                    public void onCancel() {
                        status.setText("LOGIN CANCELLED");

                    }

                    @Override
                    public void onError(FacebookException error) {
                        status.setText("ERROR " + error.getMessage());
                    }
                });
        login.setReadPermissions("public_profile");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}