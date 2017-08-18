package com.example.hyunyoungpark.contactdetailsex;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    ListView lv ;
    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lv_contacts);
        al = new ArrayList<String>();

        //AD A RUNTIME PERMISSION
        //only adding permission in manifest file is not enough
        // you need a runtime permission
        //check wether your application is having permission?
        //if not add that permission
        if( getApplicationContext().checkSelfPermission(android.Manifest
                .permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_CONTACTS},
                    1);
        }
        //get contenetREsolver object
        //1. IS THE PATH OF CONTACT TABLE =  ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        Cursor c = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        while(c.moveToNext())
        {
            String name = c.getString(c.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            al.add(name);
        }
        lv.setAdapter(new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_list_item_1,
                        al));


    }
}