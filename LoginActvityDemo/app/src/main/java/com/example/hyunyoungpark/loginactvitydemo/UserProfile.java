package com.example.hyunyoungpark.loginactvitydemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.facebook.share.widget.ShareDialog;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hyunyoungpark on 2017-08-29.
 */

public class UserProfile extends AppCompatActivity {

    private TextView name;
    private Button logout;
    private ImageView img_user;
    private ShareDialog shareDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_userprofile);
        name = (TextView)findViewById(R.id.txt_name);
        logout = (Button)findViewById(R.id.btn_logout);
        shareDialog = new ShareDialog(this);
        Bundle bundle = getIntent().getExtras();
        String firstname = bundle.get("name").toString();
        String lastname = bundle.get("surname").toString();
        String imgUrl = bundle.get("imageUrl").toString();
        name.setText(" "+firstname + " "+lastname);
        new DownloadImage((ImageView)findViewById(R.id.img_profile)).execute(imgUrl);
        logout.setOnClickListener(new View.OnClickListener())

        @Override
                public void onClick(View v) {
            LoginManager.getInstance().logOut();
            Intent login = new Intent(UserProfile.this,MainActivity1)
                    startActivity
        }
    }

    //code for downloading image from facebook
    //create a inner class that uses Bitmap
    //inner class using Asnyc for background processing

    public class DownloadImage extends AsyncTask<String, Void, Bitmap>
    {
        ImageView bmImage;

        public DownloadImage(ImageView bmImage)
        {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            String urlDisplay = params[0];
            Bitmap myImage = null;
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                myImage = BitmapFactory.decodeStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return myImage;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            bmImage.setImageBitmap(bitmap);

        }
    }
}
