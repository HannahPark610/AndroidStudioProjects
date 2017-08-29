package com.example.hyunyoungpark.loginactvitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by hyunyoungpark on 2017-08-29.
 */

public class MainActivity1 extends AppCompatActivity {
    CallbackManager callbackManager;
    ProfileTracker profileTracker;
    AccessTokenTracker tokenTracker;
    LoginButton loginButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main1);
        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                nextActivity(currentProfile);

            }
        };
        tokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
        profileTracker.startTracking();
        tokenTracker.startTracking();
        loginButton = (LoginButton)findViewById(R.id.btn_login1);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                nextActivity(profile);
                Toast.makeText(MainActivity1.this,"Loging in..", Toast.LENGTH_LONG);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        loginButton.setReadPermissions("user_friends");
    }

    private void nextActivity(Profile profile)
    {
        if(profile!=null)
        {
            Intent main = new Intent(MainActivity1.this, UserProfile.class);
            main.putExtra("name", profile.getFirstName());
            main.putExtra("surname",profile.getLastName());
            main.putExtra("imageUrl", profile.getProfilePictureUri(200,200));
            startActivity(main);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        nextActivity(profile);
    }

    @Override
    protected void onStop() {
        super.onStop();
        profileTracker.stopTracking();
        tokenTracker.get
    }
}
